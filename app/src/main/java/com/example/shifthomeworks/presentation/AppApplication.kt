package com.example.shifthomeworks.presentation

import android.app.Application
import com.example.shifthomeworks.di.DaggerApplicationComponent

class AppApplication: Application() {

    val component by lazy{
        DaggerApplicationComponent.factory().create(this)
    }

}
