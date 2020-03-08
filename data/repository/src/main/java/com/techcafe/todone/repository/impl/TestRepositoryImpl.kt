package com.techcafe.todone.repository.impl

import android.util.Log
import com.techcafe.todone.repository.TestRepository

// TODO: 削除
class TestRepositoryImpl : TestRepository {
    override fun test() {
        Log.d("TestRepositoryImpl", "good!")
    }
}