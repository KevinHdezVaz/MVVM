package com.example.mvvm.domain.model

import com.example.mvvm.data.database.entities.QuoteEntiti
import com.example.mvvm.data.model.QuoteModel

data class Quote(val quote:String, val author:String)

 fun QuoteModel.toDomain() = Quote(quote,author)
fun QuoteEntiti.toDomain() = Quote(quote,author)
