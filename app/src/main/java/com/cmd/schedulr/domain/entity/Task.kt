package com.cmd.schedulr.domain.entity

import androidx.compose.ui.graphics.Color
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.Companion.SET_NULL
import androidx.room.PrimaryKey
import com.cmd.schedulr.domain.type.WeekType
import com.example.schedulr.domain.type.WeekDay
import java.time.LocalDate
import java.time.LocalTime

@Entity(
    tableName = "tasks",
    foreignKeys = [
        ForeignKey(
            parentColumns = ["id"],
            childColumns = ["category_id"],
            entity = Category::class,
            onDelete = SET_NULL
        )
    ]
)
data class Task (
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String,
    val place: String,
    val description: String?,
    @ColumnInfo(name = "start_time")
    val startTime: LocalTime,
    @ColumnInfo(name = "end_time")
    val endTime: LocalTime,
    @ColumnInfo(name = "week_day")
    val weekDay: WeekDay?,
    @ColumnInfo(name = "week_type")
    val weekType: WeekType?,
    val date: LocalDate?,
    @ColumnInfo(name = "category_id")
    val categoryId: Int,
    @ColumnInfo(name = "color_rgb")
    val colorRGB: Int
)