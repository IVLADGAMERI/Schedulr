package com.example.schedulr.domain.type.converter

import androidx.room.TypeConverter
import java.time.LocalTime
import java.time.format.DateTimeFormatter

class LocalTimeConverter {
    private val formatter = DateTimeFormatter.ISO_LOCAL_TIME

    @TypeConverter
    fun fromLocalTimeToString(time: LocalTime?): String? {
        return time?.format(formatter)
    }

    @TypeConverter
    fun toLocalTimeFromString(data: String?): LocalTime? {
        return data?.let { LocalTime.parse(data, formatter) }
    }
}