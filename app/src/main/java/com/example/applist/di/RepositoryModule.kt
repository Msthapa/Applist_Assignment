package com.example.applist.di

import com.bumptech.glide.RequestManager
import com.example.applist.model.dao.ManageAppDao
import com.example.applist.model.retrofitContract.AppsApiService
import com.example.applist.repository.Repository
import com.example.applist.repository.RepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideUserRepository(
        api: AppsApiService,
        dao: ManageAppDao,
        glide: RequestManager
    ): Repository = RepositoryImpl(api, dao)
}