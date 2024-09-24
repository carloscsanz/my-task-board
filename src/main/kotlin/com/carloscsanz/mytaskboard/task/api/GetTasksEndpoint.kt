package com.carloscsanz.mytaskboard.task.api

import com.carloscsanz.mytaskboard.task.api.dto.Task
import com.carloscsanz.mytaskboard.task.domain.TaskRepository
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
class GetTasksEndpoint(
    private val repository: TaskRepository,
) {
    @GetMapping("/tasks", produces = [MediaType.APPLICATION_JSON_VALUE])
    @ResponseStatus(HttpStatus.OK)
    fun getTasks(): Collection<Task> =
        repository
            .findAll()
            .map { Task.fromDomain(it) }
}
