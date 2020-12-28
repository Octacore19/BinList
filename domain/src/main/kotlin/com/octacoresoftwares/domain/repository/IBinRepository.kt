package com.octacoresoftwares.domain.repository

import com.octacoresoftwares.domain.model.BaseResponse
import com.octacoresoftwares.domain.model.BinResponse
import kotlinx.coroutines.flow.Flow

interface IBinRepository {
    suspend fun fetchCardRepository(cardNumber: String): Flow<BaseResponse<BinResponse>>
//    suspend fun fetchCardRepository(cardNumber: String): Flow<Int>
}