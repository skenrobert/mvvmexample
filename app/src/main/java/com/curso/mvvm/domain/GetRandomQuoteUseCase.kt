package com.curso.mvvm.domain

import com.curso.mvvm.data.QuoteRepository
import com.curso.mvvm.data.model.QuoteModel
import com.curso.mvvm.domain.model.Quote
import javax.inject.Inject

class GetRandomQuoteUseCase @Inject constructor(private val repository: QuoteRepository) {

    suspend operator fun invoke(): Quote? { //invoke is the same (val GetRandomQuoteUseCase = GetRandomQuoteUseCase() ), and return after realize calculate
        val quotes = repository.getAllQuotesFromDatabase()// local, date in memory optimize recurse, in app not need real time
        if (!quotes.isNullOrEmpty()) {
            val randomNumber = (quotes.indices).random() // size quotes apply random (indices(list) == length(array))
            return quotes[randomNumber] // return quotes random 
        }
        return null
    }
}