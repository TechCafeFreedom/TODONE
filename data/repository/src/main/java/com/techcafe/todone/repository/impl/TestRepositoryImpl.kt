package com.techcafe.todone.repository.impl

import android.util.Log
import com.techcafe.todone.db.internal.dao.UserEntityDao
import com.techcafe.todone.repository.TestRepository

// TODO: 削除
class TestRepositoryImpl(private val userDao:UserEntityDao) : TestRepository {
    override suspend fun test() {
        Log.d("TestRepositoryImpl", "good!")
        Log.d("TestRepositoryImpl", userDao.getAllUser().toString())
    }
}