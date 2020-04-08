package com.techcafe.todone.db.internal

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.techcafe.todone.db.internal.converter.DateConverter
import com.techcafe.todone.db.internal.dao.*
import com.techcafe.todone.db.internal.entity.*

@Database(
    entities = [
        UserEntity::class,
        TodoEntity::class,
        ProjectEntity::class,
        LabelEntity::class,
        TodoWithLabel::class,
        ProjectWithLabel::class
    ],
    version = 1
)
@TypeConverters(DateConverter::class)
abstract class LocalDataBase : RoomDatabase() {
    abstract fun userEntityDao(): UserEntityDao
    abstract fun projectEntityDao(): ProjectEntityDao
    abstract fun todoEntityDao(): TodoEntityDao
    abstract fun labelEntityDao(): LabelEntityDao

    abstract fun todoLabelEntityDao(): TodoWithLabelDao
    abstract fun projectLabelEntityDao(): ProjectWithLabelDao
}
