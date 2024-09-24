package com.carloscsanz.mytaskboard.task.domain

interface TaskRepository {
    fun findAll(): Set<Task>
}
