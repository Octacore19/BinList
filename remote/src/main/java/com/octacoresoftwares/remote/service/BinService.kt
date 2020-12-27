package com.octacoresoftwares.remote.service

import com.octacoresoftwares.remote.model.BaseRemoteResponse
import com.octacoresoftwares.domain.model.BinResponseModel
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Path

interface BinService {

    @GET("{bin}")
    suspend fun fetchCardDetails(@Path("bin") cardNumber: String): Flow<BaseRemoteResponse<BinResponseModel>>
}