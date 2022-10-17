package com.example.mvvm.viewmodel

import QuoteProvider
import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvm.model.QuoteModel

class QuoteViewModel: ViewModel() {
    //lifedata : permite a nuestro activity suscripbirse a un modelo nuestro y que se llame cuando se llame a dicho model

    val quoteModel= MutableLiveData<QuoteModel>()

    @SuppressLint("SuspiciousIndentation")
    fun randomQuote(){
    val currentQuote = QuoteProvider.random()
        quoteModel.postValue(currentQuote)
    }



}