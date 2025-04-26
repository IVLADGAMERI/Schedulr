package com.cmd.schedulr.domain.DAO

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.cmd.schedulr.domain.entity.Task
import com.cmd.schedulr.domain.entity.mapped.TaskMapped
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDAO {
    @Insert
    suspend fun insert(task: Task)

    @Transaction
    @Query("SELECT * FROM tasks")
    fun getAllMapped(): Flow<List<TaskMapped>>
}