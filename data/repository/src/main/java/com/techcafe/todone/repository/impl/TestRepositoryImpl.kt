package com.techcafe.todone.repository.impl

import android.util.Log
import com.techcafe.todone.db.internal.dao.ProjectEntityDao
import com.techcafe.todone.db.internal.dao.UserEntityDao
import com.techcafe.todone.db.internal.entity.DateTime
import com.techcafe.todone.db.internal.entity.ProjectEntity
import com.techcafe.todone.db.internal.entity.TodoEntity
import com.techcafe.todone.db.internal.entity.UserEntity
import com.techcafe.todone.db.internal.middleEntity.UserWithProject
import com.techcafe.todone.repository.TestRepository
import java.util.*

// TODO: 削除
class TestRepositoryImpl(
    private val userDao: UserEntityDao,
    private val projDao: ProjectEntityDao
) : TestRepository {
    override suspend fun test() {
        val data = userDao.getProjectUserList()
        Log.d("TestForLDB_user", data[0].user.toString())
        Log.d("TestForLDB_user", data[0].projectsAndTodo[0].project.toString())
        Log.d("TestForLDB_user", data[0].projectsAndTodo[0].todoList.toString())
    }
    //表示テストのためのテストデータ登録関数
    override suspend fun addTestUserData() {
        val projectId:Int = UUID.randomUUID().variant()
        val userId:String = UUID.randomUUID().toString()
        val userName = "TestUser$userId"
        userDao.insertUser(
            UserEntity(
                id = userId,
                name = userName,
                thumbnail = "https://images.dog.ceo/breeds/husky/n02110185_11626.jpg"
            )
        )
        userDao.insertProject(
            ProjectEntity(
                id = projectId,
                author = userId,
                title = "Brushing",
                description = "BrushTeeethProject",
                projectUpdatedAt = DateTime("20200320"),
                projectCreatedAt = DateTime("20200320")
            )
        )
        projDao.insertTodo(
            TodoEntity(
                id = UUID.randomUUID().variant(),
                projectId = projectId,
                title = "Washing",
                content = "TeeethTodo",
                deadline = "today",
                state = "0",
                updatedAt = DateTime("20200320"),
                createdAt = DateTime("20200320")
            )
        )
    }
    override suspend fun showAllTestData(): List<UserWithProject> = userDao.getProjectUserList()
}

