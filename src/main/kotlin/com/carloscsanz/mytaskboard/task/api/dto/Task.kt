package com.carloscsanz.mytaskboard.task.api.dto

import kotlinx.serialization.Serializable

@Serializable
data class Task(
    val name: String,
    val description: String,
    val status: TaskStatus,
)
