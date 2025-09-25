package dev.stanislavskyi.todolist.data.repository

import dev.stanislavskyi.todolist.data.local.task.TaskDao
import dev.stanislavskyi.todolist.data.local.task.TaskDbModel
import dev.stanislavskyi.todolist.domain.model.Task
import javax.inject.Inject

class TaskDatabaseRepositoryImpl @Inject constructor(
    private val taskDao: TaskDao
) {

    suspend fun insert(task: Task) {

        val dbModel = TaskDbModel(
            task.id,
            task.title,
            task.description,
            task.isDone
        )

        taskDao.insertTask(dbModel)
    }

    suspend fun getAll(): List<Task> {
        return taskDao.getAllTask().map {
            mapDbModelToEntity(it)
        }
    }

    fun mapDbModelToEntity(dbModel: TaskDbModel): Task =
        Task(
            dbModel.id,
            dbModel.title,
            dbModel.description,
            dbModel.isDone
        )

}