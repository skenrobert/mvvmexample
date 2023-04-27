package com.curso.mvvm.core

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper { //TODO: route const that api (specific is in data.network.QuoteApiClient)
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://drawsomething-59328-default-rtdb.europe-west1.firebasedatabase.app/")
            .addConverterFactory(GsonConverterFactory.create()) // convert Json to Object
            .build()
    }
}