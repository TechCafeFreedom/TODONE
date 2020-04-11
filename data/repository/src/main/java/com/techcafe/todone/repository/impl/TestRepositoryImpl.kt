package com.techcafe.todone.repository.impl

import com.techcafe.todone.db.internal.dao.*
import com.techcafe.todone.db.internal.entity.*
import com.techcafe.todone.repository.TestRepository
import java.util.*

// TODO: 削除
class TestRepositoryImpl(
    private val userDao: UserEntityDao,
    private val projDao: ProjectEntityDao,
    private val todoDao: TodoEntityDao,
    private val todoLabelDao: TodoWithLabelDao,
    private val labelDao: LabelEntityDao,
    private val projLabelDao: ProjectWithLabelDao
) : TestRepository {
    // 表示テストのためのテストデータ登録関数
    override suspend fun getUserList(): List<UserEntity> =
            userDao.getUserList()
    override suspend fun getUserById(userId: String): UserEntity? =
            userDao.getUserById(userId)

    override suspend fun getBindProjectList(userId: String): List<ProjectEntity> =
            projDao.getBindProjectList(userId)

    override suspend fun getProjectById(projectId: Int): ProjectEntity? =
            projDao.getProjectById(projectId)

    override suspend fun getBindTodoList(projectId: Int): List<TodoEntity> =
            todoDao.getBindTodoById(projectId)

    override suspend fun getTodoById(todoId: Int): TodoEntity? =
            todoDao.getTodoById(todoId)

    override suspend fun getLabelByProjectId(projectId: Int) =
            projLabelDao.getLabelsForproject(projectId)

    override suspend fun getLabelByTodoId(todoId: Int) =
            todoLabelDao.getLabelsForTodo(todoId)

    // ラベル付け系
    override suspend fun todoBindLabel(todoId: Int, labelId: Int) =
            todoLabelDao.bindLabel(TodoWithLabel(todoId, labelId))

    override suspend fun projectBindLabel(projectId: Int, labelId: Int) =
            projLabelDao.bindLabel(ProjectWithLabel(projectId, labelId))

    // Insert系
    override suspend fun insertUser(userEntity: UserEntity) =
            userDao.insertUser(userEntity)

    override suspend fun insertProject(projectEntity: ProjectEntity) =
            projDao.insertProject(projectEntity)

    override suspend fun insertTodo(todoEntity: TodoEntity) =
            todoDao.insertTodo(todoEntity)

    override suspend fun insertLabel(labelEntity: LabelEntity) =
            labelDao.insertLabel(labelEntity)
}
