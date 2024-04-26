package com.example.shifthomeworks.di

import android.app.Application
import com.example.shifthomeworks.presentation.ListContactsFragment
import com.example.shifthomeworks.presentation.MainActivity
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component(
    modules = [DataModule::class, ViewModelModule::class]
)
interface ApplicationComponent {
    @Component.Factory
    interface Factory{

        fun create(
            @BindsInstance application: Application
        ):ApplicationComponent
    }


    fun inject(fragment: ListContactsFragment)


}