package com.carloscsanz.mytaskboard.task.domain

class Task(
    val name: Name,
    val description: Description,
    val status: Status,
) {
    @JvmInline
    value class Name(val value: String)

    @JvmInline
    value class Description(val value: String)

    enum class Status {
        TO_DO,
        IN_PROGRESS,
        DONE,
        WONT_DO;
    }
}
