package com.techcafe.todone.db.internal

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.techcafe.todone.db.internal.converter.DateConverter
import com.techcafe.todone.db.internal.dao.ProjectEntityDao
import com.techcafe.todone.db.internal.dao.UserEntityDao
import com.techcafe.todone.db.internal.entity.ProjectEntity
import com.techcafe.todone.db.internal.entity.TodoEntity
import com.techcafe.todone.db.internal.entity.UserEntity

@Database(
    entities = arrayOf(
        UserEntity::class,
        ProjectEntity::class,
        TodoEntity::class
    ),
    version = 1
)
@TypeConverters(DateConverter::class)
abstract class LocalDataBase: RoomDatabase(){
    abstract fun UserEntityDao(): UserEntityDao
    abstract fun ProjectEntityDao(): ProjectEntityDao
}