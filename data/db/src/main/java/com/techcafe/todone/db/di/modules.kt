package com.techcafe.todone.db.di

import androidx.room.Room
import com.techcafe.todone.db.internal.LocalDataBase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dbModule = module {
    single {
        Room.databaseBuilder(androidContext(), LocalDataBase::class.java, "LocalDataBase.db")
            .fallbackToDestructiveMigration()
            .build()
    }
    factory { get<LocalDataBase>().userEntityDao() }
    factory { get<LocalDataBase>().boardEntityDao() }
    factory { get<LocalDataBase>().labelEntityDao() }
    factory { get<LocalDataBase>().cardEntityDao() }
}
