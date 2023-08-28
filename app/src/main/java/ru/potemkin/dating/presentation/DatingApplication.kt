package ru.potemkin.dating.presentation

import android.app.Application
import ru.potemkin.dating.di.DaggerApplicationComponent

class DatingApplication: Application() {


    val component by lazy{
        DaggerApplicationComponent.factory().create(this)
    }
}