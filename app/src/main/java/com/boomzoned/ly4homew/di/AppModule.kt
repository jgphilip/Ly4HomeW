package com.boomzoned.ly4homew.di

import android.app.Application
import android.content.Context
import com.boomzoned.ly4homew.data.repository.SongsRepositoryImpl
import com.boomzoned.ly4homew.domain.repository.SongsRepository
import com.boomzoned.ly4homew.domain.usecases.FetchSongsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesSongsRepository(@ApplicationContext context: Context): SongsRepository {
        return SongsRepositoryImpl(context)

    }

    @Provides
    @Singleton
    fun providesUseCase(repository: SongsRepository): FetchSongsUseCase {
        return FetchSongsUseCase(repository)
    }


}