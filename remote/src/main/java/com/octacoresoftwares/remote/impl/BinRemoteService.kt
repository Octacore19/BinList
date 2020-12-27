package com.octacoresoftwares.remote.impl

import com.octacoresoftwares.remote.mappers.toRepo
import com.octacoresoftwares.remote.service.BinService
import com.octacoresoftwares.remote.utils.performErrorCalls
import com.octacoresoftwares.repository.model.BaseRepositoryResponse
import com.octacoresoftwares.repository.model.BinResponseEntity
import com.octacoresoftwares.repository.remote.IBinService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class BinRemoteService @Inject constructor(private val service: BinService) :
    IBinService {

    override suspend fun fetchCardDetails(cardNumber: String): Flow<BaseRepositoryResponse<BinResponseEntity>> =
        flow {
            service.fetchCardDetails(cardNumber).performErrorCalls().collect {
                emit(
                    BaseRepositoryResponse(
                        success = it.success,
                        hasError = it.hasError,
                        exceptions = it.exceptions,
                        data = it.data?.toRepo()
                    )
                )
            }
        }
}