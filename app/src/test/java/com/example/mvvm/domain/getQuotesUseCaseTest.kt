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


internal class getQuotesUseCaseTest{

    @RelaxedMockK
    private lateinit var  repository: QuoteRepository
    private lateinit var getQuotesUseCase : getQuotesUseCase
    @Before
    fun onBefore(){
        MockKAnnotations.init(this)
        getQuotesUseCase = getQuotesUseCase(repository)
    }

    @Test
    fun valoresvaciosRetornarDatabase() = runBlocking {
        //GIVEN
        coEvery { repository.getAllQuotesFromApi() }returns emptyList()


        //WHEN
        getQuotesUseCase()


        //THEN
        coVerify(exactly =1 ) { repository.getAllQuotesFromDatabase() }
    }


    @Test
    fun valoresvaciosRetornarAPi() = runBlocking {
        //GIVEN
        val myList = listOf(Quote("SUSCRIBETE YA","AristiDevs"))
        coEvery { repository.getAllQuotesFromApi() }returns myList

        //WHEN
        val respuesta = getQuotesUseCase()

        //THEN
        coVerify(exactly =1 ) { repository.clearQuotes() }
        coVerify(exactly =1 ) { repository.insertQuotes(any()) }
        coVerify(exactly =0 ) { repository.getAllQuotesFromDatabase() }
        assert(myList==respuesta)

    }
}