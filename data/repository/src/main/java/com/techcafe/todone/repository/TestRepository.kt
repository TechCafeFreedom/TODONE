package com.techcafe.todone.repository

import com.techcafe.todone.db.internal.entity.BoardEntity
import com.techcafe.todone.db.internal.entity.CardEntity
import com.techcafe.todone.db.internal.entity.LabelEntity
import com.techcafe.todone.db.internal.entity.UserEntity

// TODO: 削除
interface TestRepository {
    // データ取得系 List
    suspend fun getUserList(): List<UserEntity>
    suspend fun getUserById(userId: String): UserEntity?

    suspend fun getBindBoardList(userId: String): List<BoardEntity>
    suspend fun getBoardById(projectId: Int): BoardEntity?

    suspend fun getCardListByBoardId(boardId: Int): List<CardEntity>
    suspend fun getCardById(cardId: Int): CardEntity?

    suspend fun getLabelByCardId(cardId: Int): List<LabelEntity>

    // ラベルづけ
    suspend fun cardBindLabel(cardId: Int, labelId: Int)

    // データ挿入
    suspend fun insertUser(userEntity: UserEntity)
    suspend fun insertBoard(boardEntity: BoardEntity)
    suspend fun insertCard(cardEntity: CardEntity)
    suspend fun insertLabel(labelEntity: LabelEntity)
}
