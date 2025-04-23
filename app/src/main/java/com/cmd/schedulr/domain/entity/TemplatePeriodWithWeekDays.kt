package com.example.schedulr.domain.entity

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class TemplatePeriodWithWeekDays (
    @Embedded
    val periodEntity: TemplatePeriodEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "id",
        associateBy = Junction(
            value = TemplatePeriodWeekDays::class,
            parentColumn = "templatePeriodId",
            entityColumn = "weekDayId"
        )
    )
    val days: List<WeekDayEntity>
)