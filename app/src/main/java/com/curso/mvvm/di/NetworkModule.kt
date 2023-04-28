package com.curso.mvvm.di

import com.curso.mvvm.data.network.QuoteApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module // module provider dependencies
@InstallIn(SingletonComponent::class) //in this you declare instance for all project, exist many level (box alliance)
object NetworkModule {

    @Singleton // is recommend singleton allow create only instance this class, avoid error
    @Provides // this form, with you inject library in all project
    fun provideRetrofit():Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://drawsomething-59328-default-rtdb.europe-west1.firebasedatabase.app/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton //only this instance
    @Provides// you provide any element this form
    fun provideQuoteApiClient(retrofit: Retrofit):QuoteApiClient{
        return retrofit.create(QuoteApiClient::class.java)
    }
}