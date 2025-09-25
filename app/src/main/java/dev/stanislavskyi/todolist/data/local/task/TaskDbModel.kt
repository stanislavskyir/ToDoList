package dev.stanislavskyi.todolist.data.local.task

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "task")
data class TaskDbModel(
    @PrimaryKey
    val id: Long,
    val title: String,
    val description: String,
    val isDone: Boolean
)