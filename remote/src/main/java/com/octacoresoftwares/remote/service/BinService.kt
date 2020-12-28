package com.octacoresoftwares.remote.service

import com.octacoresoftwares.remote.model.BinResponseModel
import com.octacoresoftwares.remote.model.BaseRemoteResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface BinService {

    @GET("{bin}")
    suspend fun fetchCardDetails(@Path("bin") cardNumber: String): BaseRemoteResponse<BinResponseModel>
}