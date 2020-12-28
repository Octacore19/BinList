package com.octacoresoftwares.remote.impl

import com.octacoresoftwares.remote.mappers.toRepo
import com.octacoresoftwares.remote.service.BinService
import com.octacoresoftwares.repository.model.BaseRepositoryResponse
import com.octacoresoftwares.repository.model.BinResponseEntity
import com.octacoresoftwares.repository.remote.IBinService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class BinRemoteService @Inject constructor(private val service: BinService) : IBinService {

    override suspend fun fetchCardDetails(cardNumber: String): Flow<BaseRepositoryResponse<BinResponseEntity>> {
        return flow {
            try {
                service.fetchCardDetails(cardNumber).let {
                    emit(
                        BaseRepositoryResponse(
                            success = it.success,
                            hasError = it.hasError,
                            data = it.data?.toRepo()
                        )
                    )
                }
            } catch (e: Exception) {
                emit(
                    BaseRepositoryResponse<BinResponseEntity>(
                        success = false,
                        hasError = true,
                        message = e.localizedMessage
                    )
                )
            }
        }
    }
}