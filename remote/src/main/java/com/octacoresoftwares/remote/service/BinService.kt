package com.octacoresoftwares.remote.service

import com.octacoresoftwares.domain.model.BinResponseModel
import retrofit2.http.GET
import retrofit2.http.Path

interface BinService {

    @GET("{bin}")
    suspend fun fetchCardDetails(@Path("bin") cardNumber: String): BinResponseModel
}