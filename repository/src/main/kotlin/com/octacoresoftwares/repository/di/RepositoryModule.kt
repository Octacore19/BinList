package com.octacoresoftwares.repository.di

import com.octacoresoftwares.domain.repository.IBinRepository
import com.octacoresoftwares.repository.impl.BinRepository
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryModule {

    @Binds
    abstract fun bindBinsRepository(repo: BinRepository): IBinRepository
}