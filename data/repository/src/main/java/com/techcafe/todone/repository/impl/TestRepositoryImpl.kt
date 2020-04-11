package com.techcafe.todone.repository.impl

import com.techcafe.todone.db.internal.dao.*
import com.techcafe.todone.db.internal.entity.*
import com.techcafe.todone.db.internal.middleEntity.BoardWithLabel
import com.techcafe.todone.db.internal.middleEntity.CardWithLabel
import com.techcafe.todone.repository.TestRepository

// TODO: 削除
class TestRepositoryImpl(
    private val userDao: UserEntityDao,
    private val projDao: BoardEntityDao,
    private val cardDao: CardEntityDao,
    private val cardLabelDao: CardWithLabelDao,
    private val labelDao: LabelEntityDao,
    private val projLabelDao: BoardWithLabelDao,
    private val userProjDao: UserWithBoardDao
) : TestRepository {
    // 表示テストのためのテストデータ登録関数
    override suspend fun getUserList(): List<UserEntity> =
            userDao.getUserList()
    override suspend fun getUserById(userId: String): UserEntity? =
            userDao.getUserById(userId)

    override suspend fun getBindProjectList(userId: String): List<BoardEntity> =
            userProjDao.getBindBoardList(userId)

    override suspend fun getProjectById(projectId: Int): BoardEntity? =
            projDao.getBoardById(projectId)

    override suspend fun getBindTodoList(projectId: Int): List<CardEntity> =
            cardDao.getBindTodoById(projectId)

    override suspend fun getTodoById(todoId: Int): CardEntity? =
            cardDao.getTodoById(todoId)

    override suspend fun getLabelByProjectId(projectId: Int) =
            projLabelDao.getLabelsForBoard(projectId)

    override suspend fun getLabelByTodoId(todoId: Int) =
            cardLabelDao.getLabelsForTodo(todoId)

    // ラベル付け系
    override suspend fun todoBindLabel(todoId: Int, labelId: Int) =
            cardLabelDao.bindLabel(
                CardWithLabel(
                    todoId,
                    labelId
                )
            )

    override suspend fun projectBindLabel(projectId: Int, labelId: Int) =
            projLabelDao.bindLabel(
                BoardWithLabel(
                    projectId,
                    labelId
                )
            )

    // Insert系
    override suspend fun insertUser(userEntity: UserEntity) =
            userDao.insertUser(userEntity)

    override suspend fun insertProject(boardEntity: BoardEntity) =
            projDao.insertProject(boardEntity)

    override suspend fun insertTodo(cardEntity: CardEntity) =
            cardDao.insertCard(cardEntity)

    override suspend fun insertLabel(labelEntity: LabelEntity) =
            labelDao.insertLabel(labelEntity)
}
