package com.carloscsanz.mytaskboard.task.domain

class Task(
    val name: TaskName,
    val description: TaskDescription,
    val status: TaskStatus,
) {
    constructor(name: String, description: String, status: String) :
        this(TaskName(name), TaskDescription(description), TaskStatus.valueOf(status))
}
