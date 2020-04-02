 package com.techcafe.todone.db.internal.entity

 import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.techcafe.todone.db.internal.converter.DateTime

 @Entity(tableName = "label_item")
 data class LabelEntity(
     @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "label_id")
    val id: Int,
     @ColumnInfo(name = "label_title")
    val title: String,
     @ColumnInfo(name = "label_desc")
    val description: String,
     @ColumnInfo(name = "label_color")
    val color: String,
     @ColumnInfo(name = "label_created")
    val createdAt: DateTime,
     @ColumnInfo(name = "label_updated")
    val updatedAt: DateTime
 )
