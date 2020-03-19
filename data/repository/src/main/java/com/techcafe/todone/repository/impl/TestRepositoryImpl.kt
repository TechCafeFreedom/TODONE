package com.techcafe.todone.repository.impl

import android.util.Log
import com.techcafe.todone.db.internal.dao.UserEntityDao
import com.techcafe.todone.db.internal.entity.DateTime
import com.techcafe.todone.db.internal.entity.ProjectEntity
import com.techcafe.todone.db.internal.entity.UserEntity
import com.techcafe.todone.repository.TestRepository
import java.util.*

// TODO: 削除
class TestRepositoryImpl(private val userDao:UserEntityDao) : TestRepository {
    override suspend fun test() {
        var data = userDao.getAllUser()
        Log.d("TestRepositoryInsBefo", data.toString())
        val user:UserEntity =
            UserEntity(
                id = "0",
                name = "Kinoshita",
                thumbnail = "Nothing!!!!!!"
                )
        userDao.insertUser(user)
        data = userDao.getAllUser()
        Log.d("TestRepo_User",data[0].user.toString())
        Log.d("TestRepo_Proj",data[0].projects.toString())
        val project:ProjectEntity = ProjectEntity(
            id = UUID.randomUUID().variant(),
            author = "0",
            title = "Turami.inc",
            description = "TestForInsert",
            projectCreatedAt = DateTime("20200319"),
            projectUpdatedAt = DateTime("20200319")
        )
        userDao.insertProject(project)
        data = userDao.getAllUser()
        Log.d("TestRepo_User1",data[0].user.toString())
        Log.d("TestRepo_Proj1",data[0].projects.toString())
        val project2:ProjectEntity = ProjectEntity(
            id = UUID.randomUUID().variant(),
            author = "0",
            title = "Umami.inc",
            description = "TestForInsert",
            projectCreatedAt = DateTime("20200319"),
            projectUpdatedAt = DateTime("20200319")
        )
        userDao.insertProject(project2)
        data = userDao.getAllUser()
        Log.d("TestRepo_User2",data[0].user.toString())
        Log.d("TestRepo_Proj2",data[0].projects.toString())
    }
}