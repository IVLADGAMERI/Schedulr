package com.example.schedulr.domain.entity

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.cmd.schedulr.domain.entity.TemplatePeriodWeekNumberEntity

data class TemplatePeriodWithRelations (
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
    val days: List<WeekDayEntity>,
    @Relation(
        parentColumn = "id",
        entityColumn = "templatePeriodId",
        entity = TemplatePeriodWeekNumberEntity::class
    )
    val weekNumbers: List<TemplatePeriodWeekNumberEntity>
)