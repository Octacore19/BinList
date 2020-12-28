package com.octacoresoftwares.binlist

import com.octacoresoftwares.binlist.di.AppComponent
import com.octacoresoftwares.binlist.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.DispatchingAndroidInjector
import javax.inject.Inject

class MainApplication: DaggerApplication() {

    lateinit var appComponent: AppComponent

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        appComponent = DaggerAppComponent.factory()
            .create(this)
        return appComponent
    }

    override fun androidInjector(): AndroidInjector<Any> = androidInjector
}