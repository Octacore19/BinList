package com.octacoresoftwares.remote.di

import com.octacoresoftwares.remote.BuildConfig
import com.octacoresoftwares.remote.service.BinService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module(includes = [OkHttpModule::class, GsonModule::class])
class RetrofitModule {

    @Provides
    fun provideRetrofit(client: OkHttpClient, converter: GsonConverterFactory): Retrofit  = Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .addConverterFactory(converter)
        .client(client)
        .build()

    @Provides
    fun provideBinService(retrofit: Retrofit): BinService =
        retrofit.create(BinService::class.java)
}