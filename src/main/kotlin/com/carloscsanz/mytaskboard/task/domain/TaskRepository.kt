package com.carloscsanz.mytaskboard.task.domain

interface TaskRepository {
    fun findAll(): Set<Task>

    fun create(task: Task)
}
