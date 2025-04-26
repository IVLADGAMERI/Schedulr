package com.cmd.schedulr.domain.entity.mapped

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.cmd.schedulr.domain.entity.Task
import com.cmd.schedulr.domain.entity.TaskTag
import com.cmd.schedulr.domain.entity.TaskTagCrossRef

data class TaskMapped (
    @Embedded
    val taskEntity: Task,
    @Relation(
        parentColumn = "id",
        entityColumn = "id",
        associateBy = Junction(
            value = TaskTagCrossRef::class,
            parentColumn = "task_id",
            entityColumn = "task_tag_id"
        ),
        entity = TaskTag::class,
    )
    val tags: List<TaskTagMapped>
)