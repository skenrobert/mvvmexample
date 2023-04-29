package com.curso.mvvm.data

import com.curso.mvvm.data.database.dao.QuoteDao
import com.curso.mvvm.data.database.entities.QuoteEntity
import com.curso.mvvm.data.model.QuoteModel
import com.curso.mvvm.data.network.QuoteService
import com.curso.mvvm.domain.model.Quote
import com.curso.mvvm.domain.model.toDomain
import javax.inject.Inject

class QuoteRepository @Inject constructor( //TODO: resolve for where go the consult for network in this package, this class main for get quote, this class is inject con dagger hill ( @Inject constructor)
    private val api: QuoteService,// recuperate all list Quote
    private val quoteDao: QuoteDao
) {

    suspend fun getAllQuotesFromApi(): List<Quote> {// consult Api
        val response: List<QuoteModel> = api.getQuotes()// Execute The function created in QuoteService
        return response.map { it.toDomain() }// behind QuoteModel get main class quote
    }

    suspend fun getAllQuotesFromDatabase():List<Quote>{ // consult DB, if exist (domain.model)
        val response: List<QuoteEntity> = quoteDao.getAllQuotes()
        return response.map { it.toDomain() } // behind QuoteEntity get main class quote (domain.model)
    }

    suspend fun insertQuotes(quotes:List<QuoteEntity>){ //use in GetQuotesUseCase for inject
        quoteDao.insertAll(quotes)
    }

    suspend fun clearQuotes(){ //function delete all quote data base
        quoteDao.deleteAllQuotes()//this function is make en QuotesDao
    }
}