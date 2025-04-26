package com.cmd.schedulr.domain.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(
    tableName = "task_tags_cross_ref",
    primaryKeys = ["task_id", "task_tag_id"],
    foreignKeys = [
        ForeignKey(
            parentColumns = ["id"],
            childColumns = ["task_id"],
            entity = Task::class
        ),
        ForeignKey(
            parentColumns = ["id"],
            childColumns = ["task_tag_id"],
            entity = TaskTag::class
        )
    ]
)
data class TaskTagCrossRef (
    @ColumnInfo(name = "task_id")
    val taskId: Long,
    @ColumnInfo(name = "task_tag_id")
    val taskTagId: Long
)