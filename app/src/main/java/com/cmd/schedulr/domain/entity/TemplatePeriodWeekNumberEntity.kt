package com.cmd.schedulr.domain.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import com.example.schedulr.domain.entity.TemplatePeriodEntity

@Entity(
    tableName = "template_period_week_numbers",
    primaryKeys = ["templatePeriodId", "weekNumber"],
    foreignKeys = [
        ForeignKey(
            entity = TemplatePeriodEntity::class,
            parentColumns = ["id"],
            childColumns = ["templatePeriodId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class TemplatePeriodWeekNumberEntity (
    val templatePeriodId: Long,
    val weekNumber: Int
)