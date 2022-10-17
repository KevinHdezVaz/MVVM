package com.example.mvvm.data.network

import com.example.mvvm.core.RetrofitHelper
import com.example.mvvm.data.model.QuoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class QuoteService {

    private val retrofit = RetrofitHelper.getRetrofit()
    suspend fun  getQuotes():List<QuoteModel>{

        //corrutinas kotlin , llamando a hilo secundario
        return withContext(Dispatchers.IO){
            val response =retrofit.create(QuoteApiclient::class.java).getallQuotes()
            response.body() ?: emptyList()

        }

    }

}