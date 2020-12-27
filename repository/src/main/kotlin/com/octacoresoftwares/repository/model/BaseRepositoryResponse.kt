package com.octacoresoftwares.repository.model

data class BaseRepositoryResponse <T>(
    val success: Boolean,
    val hasError: Boolean,
    val exceptions: Throwable?,
    val data: T?
)
