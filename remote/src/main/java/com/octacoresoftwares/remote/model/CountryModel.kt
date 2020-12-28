package com.octacoresoftwares.remote.model

import com.google.gson.annotations.SerializedName

data class CountryModel(
    val numeric: String?,
    @field:SerializedName("alpha2")
    val alpha: String?,
    val name: String?,
    val emoji: String?,
    val currency: String?,
    val latitude: Double?,
    val longitude: Double?
)
