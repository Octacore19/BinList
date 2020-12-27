package com.octacoresoftwares.remote.model

data class BaseRemoteResponse<T>(
    val success: Boolean = true,
    val hasError: Boolean = false,
    val exceptions: Throwable? = null,
    val data: T? = null
)