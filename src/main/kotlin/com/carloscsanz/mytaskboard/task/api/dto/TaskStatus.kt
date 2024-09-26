package com.carloscsanz.mytaskboard.task.api.dto

import com.carloscsanz.mytaskboard.task.domain.TaskStatus as DomainTaskStatus

enum class TaskStatus {
    DONE,
    IN_PROGRESS,
    WONT_DO,
    TO_DO,
    ;

    companion object {
        fun fromDomain(status: DomainTaskStatus): TaskStatus =
            when (status) {
                DomainTaskStatus.TO_DO -> TO_DO
                DomainTaskStatus.IN_PROGRESS -> IN_PROGRESS
                DomainTaskStatus.DONE -> DONE
                DomainTaskStatus.WONT_DO -> WONT_DO
            }
    }
}
