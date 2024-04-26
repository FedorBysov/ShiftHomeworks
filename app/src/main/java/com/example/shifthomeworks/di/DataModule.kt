package com.example.shifthomeworks.di

import android.app.Application
import com.example.shifthomeworks.data.AppDataBase
import com.example.shifthomeworks.data.AppImpl
import com.example.shifthomeworks.data.ContactDao
import com.example.shifthomeworks.domain.Repository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

    @ApplicationScope
    @Binds
    fun bindRepository(impl: AppImpl): Repository

    companion object{
        @ApplicationScope
        @Provides
        fun provideContactDao(
            application: Application
        ): ContactDao {
            return AppDataBase.getInstance(application).contactDao()
        }
    }

}