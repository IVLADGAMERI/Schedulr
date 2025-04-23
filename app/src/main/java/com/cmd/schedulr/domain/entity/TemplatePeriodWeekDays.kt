package com.example.schedulr.domain.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "template_period_week_days",
    primaryKeys = ["templatePeriodId, weekDayId"],
    foreignKeys = [
        ForeignKey(
            entity = TemplatePeriodEntity::class,
            parentColumns = ["id"],
            childColumns = ["templatePeriodId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = WeekDayEntity::class,
            parentColumns = ["id"],
            childColumns = ["weekDayId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class TemplatePeriodWeekDays (
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val templatePeriodId: Long,
    val weekDayId: Int
)