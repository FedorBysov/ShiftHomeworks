package com.example.shifthomeworks.di

import androidx.lifecycle.ViewModel
import com.example.shifthomeworks.presentation.ListContactsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(ListContactsViewModel::class)
    fun bindListContactsViewModel(viewModel: ListContactsViewModel): ViewModel


}