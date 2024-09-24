package com.carloscsanz.mytaskboard.task.api.dto

import kotlinx.serialization.Serializable
import com.carloscsanz.mytaskboard.task.domain.Task as DomainTask

@Serializable
data class Task(
    val name: String,
    val description: String,
    val status: TaskStatus,
) {
    companion object {
        fun fromDomain(task: DomainTask): Task {
            return Task(
                task.name.value,
                task.description.value,
                TaskStatus.fromDomain(task.status),
            )
        }
    }
}
