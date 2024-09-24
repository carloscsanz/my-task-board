package com.carloscsanz.mytaskboard.task.api

import com.carloscsanz.mytaskboard.task.api.dto.Task
import com.carloscsanz.mytaskboard.task.api.dto.TaskStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class GetTasksEndpoint {
    @GetMapping("/tasks")
    fun getTasks(): Collection<Task> {
        return listOf(
            Task("Task in Progress", "", TaskStatus.IN_PROGRESS),
            Task("Task Completed", "", TaskStatus.DONE),
            Task("Task Won’t Do", "", TaskStatus.WONT_DO),
            Task("Task To Do", "Work on a Challenge on devChallenges.io, learn TypeScript.", TaskStatus.TO_DO),
        )
    }
}
