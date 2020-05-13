package com.techcafe.todone.db.internal

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.techcafe.todone.db.internal.converter.ColorConverter
import com.techcafe.todone.db.internal.dao.*
import com.techcafe.todone.db.internal.entity.*
import com.techcafe.todone.db.internal.middleEntity.CardWithLabel
import com.techcafe.todone.db.internal.middleEntity.UserWithBoard

@Database(
    entities = [
        UserEntity::class,
        CardEntity::class,
        BoardEntity::class,
        LabelEntity::class,
        KanbanEntity::class,
        CardWithLabel::class,
        UserWithBoard::class
    ],
    version = 1
)
@TypeConverters(ColorConverter::class)
abstract class LocalDataBase : RoomDatabase() {
    abstract fun userEntityDao(): UserEntityDao
    abstract fun boardEntityDao(): BoardEntityDao
    abstract fun cardEntityDao(): CardEntityDao
    abstract fun labelEntityDao(): LabelEntityDao

    abstract fun cardLabelEntityDao(): CardWithLabelDao
    abstract fun userBoardEntityDao(): UserWithBoardDao
}
