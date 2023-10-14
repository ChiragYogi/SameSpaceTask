package com.example.samespacetask.di

import com.example.samespacetask.network.GetSongsListService
import com.example.samespacetask.repo.GetSongRepository
import com.example.samespacetask.repo.GetSongRepositoryImpl
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
object ServiceModule {


    @Singleton
    @Provides
    fun provideGetSongListService(retrofit: Retrofit): GetSongsListService {
        return retrofit.create<GetSongsListService>(GetSongsListService::class.java)
    }

    @Singleton
    @Provides
    fun provideGetSongRepository(
        getSongsListService: GetSongsListService,
    ): GetSongRepository {
        return GetSongRepositoryImpl(getSongsListService)
    }

}