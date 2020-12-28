package com.octacoresoftwares.remote.utils

import com.octacoresoftwares.remote.model.BaseRemoteResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

fun <T> BaseRemoteResponse<T>.performError(): Flow<BaseRemoteResponse<T>> =
    flow {
        try {
            emit(this@performError)
        } catch (e: Exception) {
            emit(
                BaseRemoteResponse<T>(
                    success = false,
                    hasError = true,
                    message = e.localizedMessage
                )
            )
        }
    }