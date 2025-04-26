package com.example.schedulr.domain

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.cmd.schedulr.domain.DAO.TaskDAO
import com.cmd.schedulr.domain.entity.Task
import com.cmd.schedulr.domain.entity.TaskTag
import com.cmd.schedulr.domain.entity.TaskTagCrossRef
import com.cmd.schedulr.domain.entity.UserColor
import com.cmd.schedulr.domain.type.converter.LocalDateConverter
import com.example.schedulr.domain.type.converter.LocalTimeConverter
import com.example.schedulr.domain.type.converter.WeekDayConverter

@Database(
    entities = [
        Task::class,
        TaskTag::class,
        TaskTagCrossRef::class,
        UserColor::class
               ],
    version = 1
)
@TypeConverters(WeekDayConverter::class, LocalTimeConverter::class, LocalDateConverter::class)
abstract class AppDatabase : RoomDatabase() {
    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app-db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
    abstract fun taskDao(): TaskDAO
}