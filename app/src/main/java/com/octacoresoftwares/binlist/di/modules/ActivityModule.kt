package com.octacoresoftwares.binlist.di.modules

import androidx.lifecycle.ViewModel
import com.octacoresoftwares.binlist.di.keys.ViewModelKey
import com.octacoresoftwares.binlist.viewmodels.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ActivityModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainAppViewModel(viewModel: MainViewModel): ViewModel

}