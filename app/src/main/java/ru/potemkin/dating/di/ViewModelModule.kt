package ru.potemkin.dating.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.potemkin.dating.presentation.viewmodels.MatchesViewModel
import ru.potemkin.dating.presentation.viewmodels.SwipeViewModel

@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(SwipeViewModel::class)
    fun bindSwipeViewModel(viewModel:SwipeViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MatchesViewModel::class)
    fun bindMatchesViewModel(viewModel:MatchesViewModel): ViewModel
}