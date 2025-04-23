package com.example.schedulr.domain.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "templates")
data class TemplateEntity (
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String,
)