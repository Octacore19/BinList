package com.octacoresoftwares.domain.model

data class BinResponseModel(
    val number: NumberModel? = null,
    val scheme: String? = null,
    val type: String? = null,
    val brand: String? = null,
    val prepaid: Boolean? = null,
    val country: CountryModel? = null,
    val bank: BankModel? = null
)
