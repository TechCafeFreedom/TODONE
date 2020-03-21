package com.techcafe.todone.db.di

import androidx.room.Room
import com.techcafe.todone.db.internal.LocalDataBase
import com.techcafe.todone.db.internal.dao.ProjectEntityDao
import com.techcafe.todone.db.internal.dao.UserEntityDao
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dbModule = module {
    single { Room.databaseBuilder(androidContext(),LocalDataBase::class.java,"LocalDataBase.db").fallbackToDestructiveMigration().build() }
    factory { get<LocalDataBase>().userEntityDao() }
    factory { get<LocalDataBase>().projectEntityDao() }
}
