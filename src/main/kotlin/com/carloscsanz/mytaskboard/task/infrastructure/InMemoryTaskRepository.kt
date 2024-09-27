package com.carloscsanz.mytaskboard.task.infrastructure

import com.carloscsanz.mytaskboard.task.domain.Task
import com.carloscsanz.mytaskboard.task.domain.TaskRepository
import org.springframework.stereotype.Repository

@Repository
object InMemoryTaskRepository : TaskRepository {
    private val database =
        mutableListOf(
            Task("Task in Progress", "", "IN_PROGRESS"),
            Task("Task Completed", "", "DONE"),
            Task("Task Won't Do", "", "WONT_DO"),
            Task("Task To Do", "Work on a Challenge on devChallenges.io, learn TypeScript.", "TO_DO"),
        )

    override fun findAll(): Set<Task> = database.toSet()

    override fun create(task: Task) = database.addLast(task)

    override fun clear() = database.clear()
}
