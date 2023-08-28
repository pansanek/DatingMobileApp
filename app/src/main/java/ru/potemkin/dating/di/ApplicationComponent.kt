package ru.potemkin.dating.di

import android.app.Activity
import android.app.Application
import dagger.BindsInstance
import dagger.Component
import ru.potemkin.dating.presentation.MatchesActivity
import ru.potemkin.dating.presentation.SwipeActivity

@ApplicationScope
@Component(
    modules = [
        DataModule::class,
        ViewModelModule::class
    ]
)
interface ApplicationComponent  {


    fun inject(activity: SwipeActivity)

    fun inject(activity: MatchesActivity)

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance application: Application
        ): ApplicationComponent
    }
}