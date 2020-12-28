package com.octacoresoftwares.binlist.di.modules

import com.octacoresoftwares.binlist.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityModule {

    @ContributesAndroidInjector(
        modules = [
            ActivityModule::class
        ]
    )
    abstract fun bindsMainActivity(): MainActivity
}