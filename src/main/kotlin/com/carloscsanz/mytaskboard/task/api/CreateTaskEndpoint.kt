package com.carloscsanz.mytaskboard.task.api

import com.carloscsanz.mytaskboard.task.domain.Task
import com.carloscsanz.mytaskboard.task.domain.TaskRepository
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import com.carloscsanz.mytaskboard.task.api.dto.Task as TaskDto

@RestController
class CreateTaskEndpoint(
    private val repository: TaskRepository,
) {
    @PostMapping(
        "/task",
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE],
    )
    @ResponseStatus(HttpStatus.CREATED)
    fun createTask(
        @RequestBody
        task: TaskDto,
    ) {
        val entity = Task(task.name, task.description, task.status.name)

        repository.create(entity)
    }
}
