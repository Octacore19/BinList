package com.octacoresoftwares.domain.model

data class BaseResponse <T> (
    val success: Boolean,
    val hasError: Boolean,
    val message: String?,
    val data: T?
)
