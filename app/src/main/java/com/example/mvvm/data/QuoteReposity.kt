package com.example.mvvm.data

import com.example.mvvm.data.model.QuoteModel
import com.example.mvvm.data.model.QuoteProvider
import com.example.mvvm.data.network.QuoteService
import javax.inject.Inject

class QuoteReposity @Inject constructor(

    private val api : QuoteService,
    private val quoteProvider: QuoteProvider
) {
    //servidor de backend
    suspend fun getAllQuotes():List<QuoteModel>{
        val response = api.getQuotes()
        quoteProvider.quotes = response
        return response
    }
}