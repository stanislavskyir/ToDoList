package dev.stanislavskyi.todolist.data.local.task

import androidx.room.Database
import androidx.room.RoomDatabase
import dev.stanislavskyi.todolist.data.local.task.TaskDao

@Database(entities = [TaskDbModel::class], version = 0, exportSchema = true)
abstract class TaskDatabase : RoomDatabase() {

    abstract fun taskDao(): TaskDao

    companion object {
        const val DATABASE_NAME = "task_database"
    }
}