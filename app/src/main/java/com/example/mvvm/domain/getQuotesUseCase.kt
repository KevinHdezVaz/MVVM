package com.example.mvvm.domain

import com.example.mvvm.data.QuoteReposity
import com.example.mvvm.data.model.QuoteModel

class getQuotesUseCase {

    private val repository = QuoteReposity()
    suspend operator fun invoke():List<QuoteModel>?{
        return repository.getAllQuotes()
    }
}