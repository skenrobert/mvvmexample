package com.curso.mvvm.di

import android.content.Context
import androidx.room.Room
import com.curso.mvvm.data.database.QuoteDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)// all values inject for singleton and dagger
object RoomModule { //integration (dao, entities, QuoteDatabase)

    private const val QUOTE_DATABASE_NAME = "quote_database" //name database

    @Singleton
    @Provides// create database
    fun provideRoom(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, QuoteDatabase::class.java, QUOTE_DATABASE_NAME).build() // create data base

    @Singleton
    @Provides// inject DAO in database
    fun provideQuoteDao(db: QuoteDatabase) = db.getQuoteDao()
}