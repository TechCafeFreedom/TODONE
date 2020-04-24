package com.techcafe.todone.repository

import com.techcafe.todone.db.internal.entity.*

// TODO: 削除
interface TestRepository {
    // データ取得系 List
    suspend fun getUserList(): List<UserEntity>
    suspend fun getUserById(userId: String): UserEntity?

    suspend fun getBindProjectList(userId: String): List<BoardEntity>
    suspend fun getProjectById(projectId: Int): BoardEntity?

    suspend fun getBindTodoList(projectId: Int): List<CardEntity>
    suspend fun getTodoById(todoId: Int): CardEntity?

    suspend fun getLabelByProjectId(projectId: Int): List<LabelEntity>
    suspend fun getLabelByTodoId(todoId: Int): List<LabelEntity>
    // ラベルづけ
    suspend fun todoBindLabel(todoId: Int, labelId: Int)
    suspend fun projectBindLabel(projectId: Int, labelId: Int)
    // データ挿入
    suspend fun insertUser(userEntity: UserEntity)
    suspend fun insertProject(boardEntity: BoardEntity)
    suspend fun insertTodo(cardEntity: CardEntity)
    suspend fun insertLabel(labelEntity: LabelEntity)
}
