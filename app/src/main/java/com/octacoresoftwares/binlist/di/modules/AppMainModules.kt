package com.octacoresoftwares.binlist.di.modules

import com.octacoresoftwares.remote.di.RemoteModule
import com.octacoresoftwares.remote.di.RetrofitModule
import com.octacoresoftwares.repository.di.RepositoryModule
import dagger.Module

@Module(
    includes = [
        ViewModelBuilderModule::class,
        RemoteModule::class,
        RetrofitModule::class,
        RepositoryModule::class,
        MainActivityModule::class
    ]
)
object AppMainModules