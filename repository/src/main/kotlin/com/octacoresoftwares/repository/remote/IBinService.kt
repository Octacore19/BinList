package com.octacoresoftwares.repository.remote

import com.octacoresoftwares.repository.model.BaseRepositoryResponse
import com.octacoresoftwares.repository.model.BinResponseEntity
import kotlinx.coroutines.flow.Flow

interface IBinService {
    suspend fun fetchCardDetails(cardNumber: String): Flow<BaseRepositoryResponse<BinResponseEntity>>
}