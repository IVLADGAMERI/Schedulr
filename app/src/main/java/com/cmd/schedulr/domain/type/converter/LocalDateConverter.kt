package com.cmd.schedulr.domain.type.converter

import androidx.room.TypeConverter
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class LocalDateConverter {
    private val formatter = DateTimeFormatter.ISO_LOCAL_DATE

    @TypeConverter
    fun fromLocalDateToString(date: LocalDate?): String? =
        date?.format(formatter)

    @TypeConverter
    fun toLocalDateFromString(data: String?): LocalDate? =
        data?.let { LocalDate.parse(it, formatter) }
}