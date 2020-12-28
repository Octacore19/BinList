package com.octacoresoftwares.repository.impl

import com.octacoresoftwares.domain.model.BaseResponse
import com.octacoresoftwares.domain.model.BinResponse
import com.octacoresoftwares.domain.repository.IBinRepository
import com.octacoresoftwares.repository.mappers.toResponse
import com.octacoresoftwares.repository.remote.IBinService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class BinRepository @Inject constructor(private val service: IBinService): IBinRepository {

    override suspend fun fetchCardRepository(cardNumber: String): Flow<BaseResponse<BinResponse>> {
        return flow {
            service.fetchCardDetails(cardNumber).collect {
                this.emit(
                    BaseResponse(
                        success = it.success,
                        hasError = it.hasError,
                        message = it.message,
                        data = it.data?.toResponse()
                    )
                )
            }
        }
    }
}