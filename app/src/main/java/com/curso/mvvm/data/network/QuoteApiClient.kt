package com.curso.mvvm.data.network

import com.curso.mvvm.data.model.QuoteModel
import retrofit2.Response
import retrofit2.http.GET

interface QuoteApiClient { //TODO: route specific that api (root api is in core.retrofitHelper)
    @GET("/.json")
    suspend fun getAllQuotes(): Response<List<QuoteModel>> //get list(json) each Quote
}