package com.techcafe.todone.repository

import com.techcafe.todone.db.internal.entity.*
import com.techcafe.todone.db.internal.middleEntity.UserWithProject

// TODO: 削除
interface TestRepository {
    // データ取得系 List
    suspend fun getUserList(): List<UserEntity>
    suspend fun getUserById(userId: String): UserEntity?

    suspend fun getBindProjectList(userId: String): List<ProjectEntity>
    suspend fun getProjectById(projectId: Int): ProjectEntity?

    suspend fun getBindTodoList(projectId: Int): List<TodoEntity>
    suspend fun getTodoById(todoId: Int): TodoEntity?

    suspend fun getLabelByProjectId(projectId: Int): List<LabelEntity>
    suspend fun getLabelByTodoId(todoId: Int): List<LabelEntity>
    // ラベルづけ
    suspend fun todoBindLabel(todoId: Int, labelId: Int)
    suspend fun projectBindLabel(projectId: Int, labelId: Int)
    // データ挿入
    suspend fun insertUser(userEntity: UserEntity)
    suspend fun insertProject(projectEntity: ProjectEntity)
    suspend fun insertTodo(todoEntity: TodoEntity)
    suspend fun insertLabel(labelEntity: LabelEntity)
}
