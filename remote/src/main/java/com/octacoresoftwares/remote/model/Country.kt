package com.octacoresoftwares.remote.model

data class Country(
    val numeric: String? = null,
    val alpha: String? = null,
    val name: String? = null,
    val emoji: String? = null,
    val currency: String? = null,
    val latitude: Double? = null,
    val longitude: Double? = null
)
