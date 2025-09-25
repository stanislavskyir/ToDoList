package dev.stanislavskyi.todolist.domain.model

data class Task(
    val id: Long,
    val title: String,
    val description: String,
    val isDone: Boolean
)

