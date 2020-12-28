package com.octacoresoftwares.repository.model

data class BaseRepositoryResponse <T>(
    val success: Boolean,
    val hasError: Boolean,
    val exceptions: Throwable? = null,
    val data: T? = null
)
