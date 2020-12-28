package com.octacoresoftwares.repository.model

data class BinResponseEntity(
    val number: NumberEntity?,
    val scheme: String?,
    val type: String?,
    val brand: String?,
    val prepaid: Boolean?,
    val country: CountryEntity?,
    val bank: BankEntity?
)
