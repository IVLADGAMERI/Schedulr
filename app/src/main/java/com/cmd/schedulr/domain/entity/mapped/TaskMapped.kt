package com.cmd.schedulr.domain.entity.mapped

import androidx.room.Embedded
import com.cmd.schedulr.domain.entity.Task
import com.cmd.schedulr.domain.entity.TaskTag

data class TaskMapped (
    @Embedded
    val taskEntity: Task,
    val tags: List<TaskTag>
)