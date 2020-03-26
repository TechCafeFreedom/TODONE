package com.techcafe.todone.repository.impl

import android.util.Log
import com.techcafe.todone.db.internal.converter.DateTime
import com.techcafe.todone.db.internal.dao.*
import com.techcafe.todone.db.internal.entity.*
import com.techcafe.todone.db.internal.middleEntity.UserWithProject
import com.techcafe.todone.repository.TestRepository
import java.util.*

// TODO: 削除
class TestRepositoryImpl(
    private val userDao: UserEntityDao,
    private val projDao: ProjectEntityDao,
    private val todoLabelDao: TodoWithLabelDao,
    private val labelDao: LabelEntityDao,
    private val projLabelDao: ProjectWithLabelDao
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
        val user = UserEntity(
            id = userId,
            name = userName,
            thumbnail = "https://images.dog.ceo/breeds/husky/n02110185_11626.jpg"
        )
        val project = ProjectEntity(
            id = projectId + 1,
            author = userId,
            title = "Brushing",
            description = "BrushTeeethProject",
            projectUpdatedAt = DateTime(
                "20200320"
            ),
            projectCreatedAt = DateTime(
                "20200320"
            )
        )
        val todo = TodoEntity(
            id = UUID.randomUUID().variant(),
            projectId = projectId + 1,
            title = "Washing",
            content = "TeeethTodo",
            deadline = "today",
            state = "0",
            updatedAt = DateTime("20200320"),
            createdAt = DateTime("20200320")
        )
        val label = LabelEntity(
            id = 0,
            title = "TEST_LABEL",
            description = "testForLabel",
            color = "red",
            createdAt = DateTime("20200202"),
            updatedAt = DateTime("20200202")
        )
        userDao.insertUser(user)
        userDao.insertProject(project)
        projDao.insertTodo(todo)
        labelDao.insertLabel(label)
        todoLabelDao.bindLabel(TodoWithLabel(2,1))
        projLabelDao.bindLabel(ProjectWithLabel(3,1))
        Log.d("Project", userDao.getProjectUserList().toString())
        Log.d("TodoLabel_Connect_TODO", todoLabelDao.getTodosForLabel(1).toString())
        Log.d("ProjLabel_Connect_PROJ", projLabelDao.getProjectsForLabel(1).toString())
    }
    override suspend fun getUserAndProject(): List<UserWithProject>
            = userDao.getProjectUserList()

    override suspend fun getLabelByProjectId(projectId: Int)
            = projLabelDao.getLabelsForproject(projectId)

    override suspend fun getLabelByTodoId(todoId: Int)
            = todoLabelDao.getLabelsForTodo(todoId)

    override suspend fun todoBindLabel(todoId: Int, labelId: Int)
            = todoLabelDao.bindLabel(TodoWithLabel(todoId, labelId))

    override suspend fun projectBindLabel(projectId: Int, labelId: Int)
            = projLabelDao.bindLabel(ProjectWithLabel(projectId, labelId))

    override suspend fun insertUser(userEntity: UserEntity)
            = userDao.insertUser(userEntity)

    override suspend fun insertProject(projectEntity: ProjectEntity)
            = userDao.insertProject(projectEntity)

    override suspend fun insertTodo(todoEntity: TodoEntity)
            = projDao.insertTodo(todoEntity)

    override suspend fun insertLabel(labelEntity: LabelEntity)
            = labelDao.insertLabel(labelEntity)
}

