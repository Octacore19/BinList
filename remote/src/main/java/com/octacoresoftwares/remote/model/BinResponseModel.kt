package com.octacoresoftwares.remote.model

data class BinResponseModel(
    val number: NumberModel?,
    val scheme: String?,
    val type: String?,
    val brand: String?,
    val prepaid: Boolean?,
    val country: CountryModel?,
    val bank: BankModel?
)
