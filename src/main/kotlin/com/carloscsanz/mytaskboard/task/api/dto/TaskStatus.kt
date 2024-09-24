package com.carloscsanz.mytaskboard.task.api.dto

import com.carloscsanz.mytaskboard.task.domain.Task.Status

enum class TaskStatus {
    DONE,
    IN_PROGRESS,
    WONT_DO,
    TO_DO;

    companion object {
        fun fromDomain(status: Status): TaskStatus = when (status) {
            Status.TO_DO -> TO_DO
            Status.IN_PROGRESS -> IN_PROGRESS
            Status.DONE -> DONE
            Status.WONT_DO -> WONT_DO
        }
    }
}
