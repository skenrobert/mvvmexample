package com.curso.mvvm.domain

import com.curso.mvvm.data.QuoteRepository
import com.curso.mvvm.data.database.entities.toDatabase
import com.curso.mvvm.domain.model.Quote
import javax.inject.Inject

class GetQuotesUseCase @Inject constructor(private val repository: QuoteRepository) { //this class prepared for inject with dagger hil ( @Inject constructor)
    suspend operator fun invoke():List<Quote>{//invoke is the same (val getQuotesUseCase = getQuotesUseCase() ), and return after realize calculate
        val quotes = repository.getAllQuotesFromApi()

        return if(quotes.isNotEmpty()){// search in the api, if in case no void return last line this conditional
            repository.clearQuotes()// drop database table
            repository.insertQuotes(quotes.map { it.toDatabase() }) // call function the repository and insert
            quotes
        }else{ // return this conditional in case no true behind
            repository.getAllQuotesFromDatabase() //search in database TODO: need test this code, and create data base
        }
    }
}