package com.example.schedulr.domain.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.schedulr.domain.type.WeekDay

@Entity(tableName = "week_days")
data class WeekDayEntity (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: WeekDay
)