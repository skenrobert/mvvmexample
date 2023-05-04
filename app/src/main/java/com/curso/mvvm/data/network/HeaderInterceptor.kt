package com.curso.mvvm.data.network

import okhttp3.Interceptor
import okhttp3.Response

class HeaderInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder() //Add the chain to the request to the server
            .addHeader(
                "Accept:", "application/json"
            )
           // .addHeader("ApiKey", "testwithapi")
            .build()

        return chain.proceed(request)
    }
}