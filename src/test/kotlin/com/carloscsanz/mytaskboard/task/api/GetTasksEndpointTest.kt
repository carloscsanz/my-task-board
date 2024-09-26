package com.carloscsanz.mytaskboard.task.api

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest
@AutoConfigureMockMvc
class GetTasksEndpointTest(
    @Autowired private val mockMvc: MockMvc
) {
    @Test
    fun `should retrieve all the the tasks`() {
        val expected = """
            [
                {
                    "name": "Task in Progress",
                    "description": "",
                    "status": "IN_PROGRESS"
                },
                {
                    "name": "Task Completed",
                    "description": "",
                    "status": "DONE"
                },
                {
                    "name": "Task Won't Do",
                    "description": "",
                    "status": "WONT_DO"
                },
                {
                    "name": "Task To Do",
                    "description": "Work on a Challenge on devChallenges.io, learn TypeScript.",
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