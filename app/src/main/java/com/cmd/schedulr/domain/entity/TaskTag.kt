package com.cmd.schedulr.domain.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.Companion.CASCADE
import androidx.room.PrimaryKey

@Entity(
    tableName = "task_tags",
    foreignKeys = [
        ForeignKey(
            parentColumns = ["id"],
            childColumns = ["color_id"],
            entity = UserColor::class,
            onDelete = CASCADE
        )
    ]
)
data class TaskTag (
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val name: String,
    val description: String?,
    @ColumnInfo(name = "color_id")
    val colorId: Long
)