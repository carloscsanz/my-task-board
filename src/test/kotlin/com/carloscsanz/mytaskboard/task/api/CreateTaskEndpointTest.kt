package com.carloscsanz.mytaskboard.task.api

import org.intellij.lang.annotations.Language
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest
@AutoConfigureMockMvc
class CreateTaskEndpointTest(
    @Autowired private val mockMvc: MockMvc
) {
    @Test
    fun `should retrieve all the the tasks`() {
        @Language("json")
        val content = """
            {
                "name": "Task in Progress",
                "description": "",
                "status": "IN_PROGRESS"
            } 
        """

        mockMvc
            .perform(
                post("/task")
                    .contentType(APPLICATION_JSON_VALUE)
                    .content(content)
            )
            .andExpect(status().isCreated())
    }
}