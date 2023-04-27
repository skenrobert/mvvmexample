package com.curso.mvvm.data.network

import com.curso.mvvm.core.RetrofitHelper
import com.curso.mvvm.data.model.QuoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class QuoteService @Inject constructor(private val api:QuoteApiClient) { //TODO: logic resolution where search consult DB or API

    suspend fun getQuotes(): List<QuoteModel> {
        return withContext(Dispatchers.IO) {// thread second
            val response = api.getAllQuotes() // response list Quotes for the api
            response.body() ?: emptyList()//if empty return empty list
        }
    }

}