package com.techcafe.todone.db.internal.converter

import androidx.room.TypeConverter

class DateConverter {
    @TypeConverter
    fun ConvertDate(value: Long?): DateTime? = value?.let { DateTime(it) }
    @TypeConverter
    fun DateConvertTo(date: DateTime?): Long? = date?.date
}
