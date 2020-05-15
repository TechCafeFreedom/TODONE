package com.techcafe.todone.db.internal.converter

import androidx.room.TypeConverter
import techcafe.todone.LabelColor

class ColorConverter {
    @TypeConverter
    fun ConvertColor(value: Int?): LabelColor? = value?.let { LabelColor.toLabelColor(value) }
    @TypeConverter
    fun DateConvertTo(value: LabelColor?): Int? = value?.let { LabelColor.toColorNum(value) }
}
