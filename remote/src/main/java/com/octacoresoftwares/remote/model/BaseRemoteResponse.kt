package com.octacoresoftwares.remote.model

data class BaseRemoteResponse<T>(
    val success: Boolean,
    val hasError: Boolean,
    val message: String? = null,
    val data: T? = null
)
