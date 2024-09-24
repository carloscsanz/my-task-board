package com.carloscsanz.mytaskboard.task.infrastructure

import com.carloscsanz.mytaskboard.task.domain.Task
import com.carloscsanz.mytaskboard.task.domain.TaskRepository
import org.springframework.stereotype.Repository

@Repository
object InMemoryTaskRepository : TaskRepository {
    private val database = listOf(
        Task(Task.Name("Task in Progress"), Task.Description(""), Task.Status.IN_PROGRESS),
        Task(Task.Name("Task Completed"), Task.Description(""), Task.Status.DONE),
        Task(Task.Name("Task Won't Do"), Task.Description(""), Task.Status.WONT_DO),
        Task(
            Task.Name("Task To Do"),
            Task.Description("Work on a Challenge on devChallenges.io, learn TypeScript."),
            Task.Status.TO_DO
        ),
    )

    override fun findAll(): Set<Task> = database.toSet()
}
