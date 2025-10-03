package com.example.applist.di

import android.app.Application
import androidx.room.Room
import com.example.applist.model.AppDatabase
import com.example.applist.model.dao.ManageAppDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppDatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(app: Application): AppDatabase =
        Room.databaseBuilder(app, AppDatabase::class.java, "app_db").build()

    @Provides
    fun provideAppListDao(db: AppDatabase): ManageAppDao = db.appDao()

}