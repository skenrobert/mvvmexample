package com.curso.mvvm.core

import com.curso.mvvm.data.network.HeaderInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper { //TODO: route const that api (specific is in data.network.QuoteApiClient)
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://drawsomething-59328-default-rtdb.europe-west1.firebasedatabase.app/")
            .addConverterFactory(GsonConverterFactory.create()) // convert Json to Object
            .client(getClient()) // call intercept, add headers (headerInterceptor), create below
            .build()
    }

    private fun getClient(): OkHttpClient = //this same return (=)
        OkHttpClient.Builder()
            .addInterceptor(HeaderInterceptor())// function interceptor add headersInterceptor
            .build()

    fun getRetrofitApiExample(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://reqres.in/api/users?page=2")
            .addConverterFactory(GsonConverterFactory.create()) // convert Json to Object
           // .client(getClient()) // call intercept, add headers (headerInterceptor), create below
            .build()
    }
}