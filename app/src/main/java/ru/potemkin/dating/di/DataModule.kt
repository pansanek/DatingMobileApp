package ru.potemkin.dating.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import ru.potemkin.dating.data.DatingRepositoryImpl
import ru.potemkin.dating.domain.repository.DatingRepository

@Module
interface DataModule {

    @ApplicationScope
    @Binds
    fun bindDatingRepository(impl: DatingRepositoryImpl): DatingRepository



}