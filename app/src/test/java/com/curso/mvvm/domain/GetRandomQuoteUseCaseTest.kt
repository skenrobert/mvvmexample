package com.curso.mvvm.domain

import com.curso.mvvm.data.QuoteRepository
import com.curso.mvvm.domain.model.Quote
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

internal class GetRandomQuoteUseCaseTest {
    @RelaxedMockK
    private lateinit var quoteRepository: QuoteRepository

    lateinit var getRandomQuoteUseCase: GetRandomQuoteUseCase

    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
        getRandomQuoteUseCase = GetRandomQuoteUseCase(quoteRepository)
    }

    @Test
    fun `when database is empty then return null`() = runBlocking {
        coEvery { quoteRepository.getAllQuotesFromDatabase() } returns emptyList()

        val response = getRandomQuoteUseCase()

        assert(response == null)
    }

    @Test
    fun `when database is not empty then return quote`() = runBlocking {
        val quoteList = listOf(Quote("Holi", "kenny"))

        coEvery { quoteRepository.getAllQuotesFromDatabase() } returns quoteList

        val response = getRandomQuoteUseCase()

        assert(response == quoteList.first())
    }
}