package com.example.schedulr.domain.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.time.LocalTime

@Entity(
    tableName = "template_periods",
    foreignKeys = [
        ForeignKey(
            entity = TemplateEntity::class,
            parentColumns = ["id"],
            childColumns = ["templateId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class TemplatePeriodEntity (
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val templateId: Long,
    val startTime: LocalTime,
    val endTime: LocalTime
)