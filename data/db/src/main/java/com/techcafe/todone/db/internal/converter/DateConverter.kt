package com.techcafe.todone.db.internal.converter

import androidx.room.TypeConverter

class DateConverter {
    @TypeConverter
    fun ConvertDate(value: String?): DateTime? = value?.let { DateTime(it) }
    @TypeConverter
    fun DateConvertTo(date: DateTime?): String? = date?.date
}
