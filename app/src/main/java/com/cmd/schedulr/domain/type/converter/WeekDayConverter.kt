package com.example.schedulr.domain.type.converter

import androidx.room.TypeConverter
import com.example.schedulr.domain.type.WeekDay

class WeekDayConverter {
    @TypeConverter
    fun fromWeekDayToString(day: WeekDay?): String? {
        return day?.name
    }

    @TypeConverter
    fun toWeekDayFromString(data: String?): WeekDay? {
        return data?.let { WeekDay.valueOf(data) }
    }
}