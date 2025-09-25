package dev.stanislavskyi.todolist.data.local.task

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface TaskDao {

    @Insert(onConflict = OnConflictStrategy.Companion.REPLACE)
    suspend fun insertTask(task: TaskDbModel)

    @Query("SELECT * FROM task")
    suspend fun getAllTask(): List<TaskDbModel>

    @Query("DELETE FROM task WHERE id=:id")
    suspend fun deleteById(id: Long)

}