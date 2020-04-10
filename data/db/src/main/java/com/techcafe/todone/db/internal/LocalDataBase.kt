package com.techcafe.todone.db.internal

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.techcafe.todone.db.internal.converter.DateConverter
import com.techcafe.todone.db.internal.dao.*
import com.techcafe.todone.db.internal.entity.*
import com.techcafe.todone.db.internal.middleEntity.BoardWithLabel
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
        BoardWithLabel::class,
        UserWithBoard::class
    ],
    version = 1
)
@TypeConverters(DateConverter::class)
abstract class LocalDataBase : RoomDatabase() {
    abstract fun userEntityDao(): UserEntityDao
    abstract fun projectEntityDao(): BoardEntityDao
    abstract fun todoEntityDao(): CardEntityDao
    abstract fun labelEntityDao(): LabelEntityDao

    abstract fun todoLabelEntityDao(): CardWithLabelDao
    abstract fun projectLabelEntityDao(): BoardWithLabelDao
    abstract fun userProjEntityDao(): UserWithBoardDao
}
