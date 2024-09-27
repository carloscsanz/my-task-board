package com.carloscsanz.mytaskboard.task.domain

@JvmInline
value class TaskName(val value: String) {
    init {
        require(value.isNotEmpty() || value.isNotBlank()) {
            throw EmptyTaskNameException()
        }
    }
}
