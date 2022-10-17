package com.example.mvvm.domain

import com.example.mvvm.data.QuoteReposity
import com.example.mvvm.data.model.QuoteModel
import javax.inject.Inject


 class getQuotesUseCase @Inject constructor(private val repository: QuoteReposity) {
    suspend operator fun invoke() = repository.getAllQuotes()
}