package com.techcafe.todone.db.internal.converter

import androidx.room.TypeConverter
import techcafe.todone.LabelColor

class ColorConverter {
    @TypeConverter
    fun ConvertColor(value: Int?): LabelColor? = value?.let { LabelColor.toLabelColor(it) }

    @TypeConverter
    fun ColorConvertTo(labelColor: LabelColor?): Int? = labelColor?.let {LabelColor.toLabelNumber(it)}
}
