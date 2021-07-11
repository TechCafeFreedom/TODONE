package com.techcafe.todone.repository.impl

import com.techcafe.todone.db.internal.dao.*
import com.techcafe.todone.db.internal.entity.BoardEntity
import com.techcafe.todone.db.internal.entity.CardEntity
import com.techcafe.todone.db.internal.entity.LabelEntity
import com.techcafe.todone.db.internal.entity.UserEntity
import com.techcafe.todone.db.internal.middleEntity.CardWithLabel
import com.techcafe.todone.repository.TestRepository
import javax.inject.Inject

// TODO: 削除
class TestRepositoryImpl @Inject constructor(
    private val userDao: UserEntityDao,
    private val boardDao: BoardEntityDao,
    private val cardDao: CardEntityDao,
    private val labelDao: LabelEntityDao,
    private val kanbanDao: KanbanEntityDao
) : TestRepository {
    // 表示テストのためのテストデータ登録関数
    override suspend fun getUserList(): List<UserEntity> =
        userDao.getUserList()

    override suspend fun getUserById(userId: String): UserEntity? =
        userDao.getUserById(userId)

    override suspend fun getBindBoardList(userId: String): List<BoardEntity> =
        boardDao.getBindBoardList(userId)

    override suspend fun getBoardById(boardId: Int): BoardEntity? =
        boardDao.getBoardById(boardId)

    override suspend fun getCardListByBoardId(boardId: Int): List<CardEntity> =
        cardDao.getBindCardById(boardId)

    override suspend fun getCardById(cardId: Int): CardEntity? =
        cardDao.getCardById(cardId)

    override suspend fun getLabelByCardId(cardId: Int) =
        cardDao.getLabelsForCard(cardId)

    // ラベル付け系
    override suspend fun cardBindLabel(cardId: Int, labelId: Int) =
        cardDao.bindLabel(
            CardWithLabel(
                cardId,
                labelId
            )
        )

    // Insert系
    override suspend fun insertUser(userEntity: UserEntity) =
        userDao.insertUser(userEntity)

    override suspend fun insertBoard(boardEntity: BoardEntity) =
        boardDao.insertBoard(boardEntity)

    override suspend fun insertCard(cardEntity: CardEntity) =
        cardDao.insertCard(cardEntity)

    override suspend fun insertLabel(labelEntity: LabelEntity) =
        labelDao.insertLabel(labelEntity)
}
