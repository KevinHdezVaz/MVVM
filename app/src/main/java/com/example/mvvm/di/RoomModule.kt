package com.example.mvvm.di

import android.content.Context
import androidx.room.Room
import com.example.mvvm.data.database.entities.QuoteDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)

object RoomModule {
@Singleton
@Provides
fun provideRoom(@ApplicationContext context: Context)= Room.databaseBuilder(context, QuoteDatabase::class.java,"quote_database").build()

    @Singleton
    @Provides
    fun provideQuoteDao(db:QuoteDatabase) = db.getQuoteDao()


}