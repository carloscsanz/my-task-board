package com.carloscsanz.mytaskboard.task.api

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest
@AutoConfigureMockMvc
class GetTasksEndpointTest(
    @Autowired private val mockMvc: MockMvc,
    @Autowired private val db: JdbcTemplate,
) {
    @BeforeEach
    fun setup() {
        db.update("TRUNCATE TABLE tasks")
        db.update(
            """
            INSERT INTO tasks
            VALUES
                ('c59d6960-a6ab-4ac7-83d8-8618c64586ae', 'Task A', 'Desc A', 'IN_PROGRESS'),
                ('54aa48f6-1072-48f6-8dcc-ddb18d8de8fe', 'Task B', 'Desc B', 'DONE'),
                ('b05fa048-1e68-40c6-8da1-4c7fa689a4b1', 'Task C', 'Desc C', 'WONT_DO'),
                ('5194f065-c0d4-4408-8c6c-4177ecdba650', 'Task D', 'Desc D', 'TO_DO')
            """,
        )
    }

    @Test
    fun `should retrieve all the the tasks`() {
        val expected = """
            [
                {
                    "name": "Task A",
                    "description": "Desc A",
                    "status": "IN_PROGRESS"
                },
                {
                    "name": "Task B",
                    "description": "Desc B",
                    "status": "DONE"
                },
                {
                    "name": "Task C",
                    "description": "Desc C",
                    "status": "WONT_DO"
                },
                {
                    "name": "Task D",
                    "description": "Desc D",
                    "status":"TO_DO"
                }
            ]
        """

        mockMvc
            .perform(get("/tasks"))
            .andExpect(status().isOk())
            .andExpect(content().json(expected, true))
    }
}
