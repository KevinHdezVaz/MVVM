package com.example.mvvm.domain

import com.example.mvvm.data.QuoteRepository
import com.example.mvvm.domain.model.Quote
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test


internal class GetRandomQuoteUseCaseTest {

    @RelaxedMockK
    private lateinit var  repository: QuoteRepository
    private lateinit var getRandomQuoteUseCase: GetRandomQuoteUseCase
    @Before
    fun onBefore(){
        MockKAnnotations.init(this)
        getRandomQuoteUseCase = GetRandomQuoteUseCase(repository)
    }

    @Test
    fun BDVaciaReturnNull() = runBlocking {
        //GIVEN
        coEvery { repository.getAllQuotesFromDatabase() } returns emptyList()

        //WHEN
        val response = getRandomQuoteUseCase()

        //THEN
       assert(response==null)
    }
    @Test
    fun BDReturnaQuote() = runBlocking {
        //GIVEN
         val myList = listOf(Quote("SUSCRIBETE YA","AristiDevs"))
        coEvery { repository.getAllQuotesFromDatabase() } returns myList

        //WHEN
        val response = getRandomQuoteUseCase()

        //THEN
        assert(response== myList.first())

    }




}