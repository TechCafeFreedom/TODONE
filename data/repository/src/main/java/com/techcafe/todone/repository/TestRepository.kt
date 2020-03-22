package com.techcafe.todone.repository

import com.techcafe.todone.db.internal.entity.UserEntity
import com.techcafe.todone.db.internal.middleEntity.UserWithProject

// TODO: 削除
interface TestRepository {
    suspend fun test()
    suspend fun addTestUserData(userName:String,userId:String)
    suspend fun showAllTestData():List<UserWithProject>
}