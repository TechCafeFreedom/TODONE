package com.techcafe.todone.db.internal.entity

import androidx.room.ColumnInfo

data class TodoWithLabel(
    @ColumnInfo(name = "todo_withid")
    val todoId:String,
    @ColumnInfo(name = "label_withid")
    val labelId:String
)