package com.cmd.schedulr.domain.type.converter

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.room.TypeConverter

class ColorConverter {
    @TypeConverter
    fun fromColor(color: Color): Int =
        color.toArgb()
    @TypeConverter
    fun toColor(colorInt: Int): Color =
        Color(colorInt)
}