package com.octacoresoftwares.domain.model

data class CountryModel(
    val numeric: String? = null,
    val alpha: String? = null,
    val name: String? = null,
    val emoji: String? = null,
    val currency: String? = null,
    val latitude: Double? = null,
    val longitude: Double? = null
)
