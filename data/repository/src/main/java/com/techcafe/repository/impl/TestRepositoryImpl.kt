package com.techcafe.repository.impl

import android.util.Log
import com.techcafe.repository.TestRepository

// TODO: 削除
class TestRepositoryImpl : TestRepository {
    override fun test() {
        Log.d("TestRepositoryImpl", "good!")
    }
}