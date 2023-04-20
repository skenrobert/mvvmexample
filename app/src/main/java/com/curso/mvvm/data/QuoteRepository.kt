package com.curso.mvvm.data

import com.curso.mvvm.data.database.dao.QuoteDao
import com.curso.mvvm.data.database.entities.QuoteEntity
import com.curso.mvvm.data.model.QuoteModel
import com.curso.mvvm.data.network.QuoteService
import com.curso.mvvm.domain.model.Quote
import com.curso.mvvm.domain.model.toDomain
import javax.inject.Inject

class QuoteRepository @Inject constructor(
    private val api: QuoteService,
    private val quoteDao: QuoteDao
) {

    suspend fun getAllQuotesFromApi(): List<Quote> {
        val response: List<QuoteModel> = api.getQuotes()
        return response.map { it.toDomain() }
    }

    suspend fun getAllQuotesFromDatabase():List<Quote>{
        val response: List<QuoteEntity> = quoteDao.getAllQuotes()
        return response.map { it.toDomain() }
    }

    suspend fun insertQuotes(quotes:List<QuoteEntity>){
        quoteDao.insertAll(quotes)
    }

    suspend fun clearQuotes(){
        quoteDao.deleteAllQuotes()
    }
}