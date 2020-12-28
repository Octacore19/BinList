package com.octacoresoftwares.binlist.di

import com.octacoresoftwares.binlist.MainApplication
import com.octacoresoftwares.binlist.di.modules.AppMainModules
import com.octacoresoftwares.binlist.di.modules.ViewModelBuilderModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppMainModules::class
    ]
)
interface AppComponent : AndroidInjector<MainApplication> {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance superApp: MainApplication): AppComponent
    }
}