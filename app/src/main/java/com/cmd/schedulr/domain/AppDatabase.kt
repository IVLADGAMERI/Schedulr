package com.example.schedulr.domain

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.schedulr.domain.entity.BlockEntity
import com.example.schedulr.domain.entity.TemplateEntity
import com.example.schedulr.domain.entity.TemplatePeriodEntity
import com.example.schedulr.domain.type.converter.LocalTimeConverter
import com.example.schedulr.domain.type.converter.WeekDayConverter

@Database(
    entities = [TemplateEntity::class, TemplatePeriodEntity::class, BlockEntity::class],
    version = 1
)
@TypeConverters(WeekDayConverter::class, LocalTimeConverter::class)
abstract class AppDatabase : RoomDatabase() {
}