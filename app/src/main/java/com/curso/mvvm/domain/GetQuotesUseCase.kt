package com.curso.mvvm.domain

import com.curso.mvvm.data.QuoteRepository
import com.curso.mvvm.data.database.entities.toDatabase
import com.curso.mvvm.domain.model.Quote
import javax.inject.Inject

class GetQuotesUseCase @Inject constructor(private val repository: QuoteRepository) {
    suspend operator fun invoke():List<Quote>{//invoke is the same (val getQuotesUseCase = getQuotesUseCase() ), and return after realize calculate
        val quotes = repository.getAllQuotesFromApi()

        return if(quotes.isNotEmpty()){
            repository.clearQuotes()
            repository.insertQuotes(quotes.map { it.toDatabase() })
            quotes
        }else{
            repository.getAllQuotesFromDatabase()
        }
    }
}