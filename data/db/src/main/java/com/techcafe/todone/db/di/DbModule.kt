package com.techcafe.todone.db.di

import android.content.Context
import androidx.room.Room
import com.techcafe.todone.db.internal.LocalDataBase
import com.techcafe.todone.db.internal.dao.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DbModule {

    @Singleton
    @Provides
    fun provideLocalDatabase(@ApplicationContext context: Context): LocalDataBase =
        Room.databaseBuilder(context, LocalDataBase::class.java, "LocalDatabase.db")
            .fallbackToDestructiveMigration()
            .build()

    @Singleton
    @Provides
    fun provideUserDao(database: LocalDataBase): UserEntityDao =
        database.userEntityDao()

    @Singleton
    @Provides
    fun provideBoardDao(database: LocalDataBase): BoardEntityDao =
        database.boardEntityDao()

    @Singleton
    @Provides
    fun provideLabelDao(database: LocalDataBase): LabelEntityDao =
        database.labelEntityDao()

    @Singleton
    @Provides
    fun provideCardDao(database: LocalDataBase): CardEntityDao =
        database.cardEntityDao()

    @Singleton
    @Provides
    fun provideKanbanDao(database: LocalDataBase): KanbanEntityDao =
        database.kanbanEntityDao()
}
