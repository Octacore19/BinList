package com.octacoresoftwares.remote.di

import com.octacoresoftwares.remote.interceptors.ResponseInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

@Module
class OkHttpModule {

    @Provides
    fun provideResponseInterceptor(): Interceptor = ResponseInterceptor()

    @Provides
    fun provideOkHttpClient(responseInterceptor: ResponseInterceptor):OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        return OkHttpClient.Builder()
            .readTimeout(30, TimeUnit.SECONDS)
            .connectTimeout(30, TimeUnit.SECONDS)
            .addInterceptor(responseInterceptor)
            .addInterceptor(loggingInterceptor)
            .build()
    }
}