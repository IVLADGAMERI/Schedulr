package com.cmd.schedulr.domain.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "user_colors",
    indices = [
        Index(value = ["hex_value"], unique = true)
    ]
)
data class UserColor (
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    @ColumnInfo(name = "hex_value")
    val hexValue: String
)