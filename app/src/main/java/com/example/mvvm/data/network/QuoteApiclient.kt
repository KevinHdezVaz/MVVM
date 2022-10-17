package com.example.mvvm.data.network

import com.example.mvvm.data.model.QuoteModel
import retrofit2.Response
import retrofit2.http.GET

interface QuoteApiclient {
    @GET("/.json")
    suspend fun getallQuotes():Response<List<QuoteModel>>
}