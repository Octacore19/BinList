package com.octacoresoftwares.remote.utils

import com.octacoresoftwares.remote.model.BaseRemoteResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow

internal fun <T> Flow<BaseRemoteResponse<T>>.performErrorCalls(): Flow<BaseRemoteResponse<T>> =
    flow {
        try {
            collect { value ->
                emit(value)
            }
        } catch (e: Exception) {
            emit(
                BaseRemoteResponse<T>(
                    success = false,
                    hasError = true,
                    exceptions = e
                )
            )
        }
    }