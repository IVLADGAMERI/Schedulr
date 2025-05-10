package com.cmd.schedulr.domain.entity

import androidx.compose.ui.graphics.Color
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "task_tags",
)
data class TaskTag (
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val name: String,
    val description: String?,
    @ColumnInfo(name = "color_rgb")
    val colorRGB: Int
)