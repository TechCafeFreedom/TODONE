package com.techcafe.todone.repository.impl

import android.util.Log
import com.techcafe.todone.db.internal.dao.ProjectEntityDao
import com.techcafe.todone.db.internal.dao.UserEntityDao
import com.techcafe.todone.db.internal.entity.DateTime
import com.techcafe.todone.db.internal.entity.ProjectEntity
import com.techcafe.todone.db.internal.entity.TodoEntity
import com.techcafe.todone.db.internal.entity.UserEntity
import com.techcafe.todone.repository.TestRepository
import java.util.*

// TODO: 削除
class TestRepositoryImpl(
    private val userDao:UserEntityDao,
    private val projDao:ProjectEntityDao
) : TestRepository {
    override suspend fun test() {
        userDao.insertUser(
            UserEntity(
                id = "0",
                name = "Kinoshita",
                thumbnail = "https://images.dog.ceo/breeds/husky/n02110185_11626.jpg"
            )
        )
        userDao.insertProject(
            ProjectEntity(
                id = UUID.randomUUID().variant(),
                author = "0",
                title = "Brushing",
                description = "Teeeth",
                projectUpdatedAt = DateTime("20200320") ,
                projectCreatedAt = DateTime("20200320")
            )
        )
        projDao.insertTodo(
            TodoEntity(
                id = UUID.randomUUID().variant(),
                projectId = "2",
                title = "Washing",
                content = "Teeeth",
                deadline = "today",
                state = "0",
                updatedAt = DateTime("20200320") ,
                createdAt = DateTime("20200320")
            )
        )
        val data = userDao.getProjectUserList()
        Log.d("TestForLDB_user", data[0].user.toString())
        Log.d("TestForLDB_user", data[0].projectsAndTodo[0].project.toString())
        Log.d("TestForLDB_user", data[0].projectsAndTodo[0].todoList.toString())
    }
}