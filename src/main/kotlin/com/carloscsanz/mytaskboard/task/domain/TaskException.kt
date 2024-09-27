package com.carloscsanz.mytaskboard.task.domain

sealed class TaskException(message: String) : Exception(message)

class EmptyTaskNameException : TaskException("Task name cannot be empty or blank")
