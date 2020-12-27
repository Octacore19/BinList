package com.octacoresoftwares.remote.di

import com.octacoresoftwares.remote.impl.BinRemoteService
import com.octacoresoftwares.repository.remote.IBinService
import dagger.Binds
import dagger.Module

@Module
abstract class RemoteModule {

    @Binds
    abstract fun bindsRemoteService(service: BinRemoteService): IBinService
}