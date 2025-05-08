package com.cmd.schedulr.domain.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.cmd.schedulr.domain.DAO.TaskDAO
import com.cmd.schedulr.domain.entity.Task
import com.cmd.schedulr.domain.entity.mapped.TaskMapped
import com.cmd.schedulr.domain.AppDatabase
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class TaskViewModel(application: Application): AndroidViewModel(application) {
    private val taskDAO: TaskDAO

    fun insert(task: Task) {
        viewModelScope.launch {
            taskDAO.insert(task)
        }
    }

    init {
        val database = AppDatabase.getInstance(application.applicationContext)
        taskDAO = database.taskDao()
    }
    val tasks: StateFlow<List<TaskMapped>> = taskDAO.getAllMapped()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )
}