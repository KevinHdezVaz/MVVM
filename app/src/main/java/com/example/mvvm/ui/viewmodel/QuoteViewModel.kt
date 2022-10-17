package com.example.mvvm.ui.viewmodel

import com.example.mvvm.data.model.QuoteProvider
import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvm.data.model.QuoteModel
import com.example.mvvm.domain.GetRandomQuoteUseCase
import com.example.mvvm.domain.getQuotesUseCase
 import kotlinx.coroutines.launch

class QuoteViewModel: ViewModel() {

    val quoteModel= MutableLiveData<QuoteModel>()
    val isloading = MutableLiveData<Boolean>()
    var getquoatesUsesCase = getQuotesUseCase()
     var getRandomQuoteUseCase = GetRandomQuoteUseCase()

    //llamada al servidor
    fun onCreate() {

    viewModelScope.launch {

        isloading.postValue(true)
        val result = getquoatesUsesCase()
        //para que se muestre un ejemplo y no se muestra nada a ciegas
        if(!result.isNullOrEmpty()){
            quoteModel.postValue(result[0])
            isloading.postValue(false)

        }

    }
    }
    //lifedata : permite a nuestro activity suscripbirse a un modelo nuestro y que se llame cuando se llame a dicho model

    fun randomQuote() {
        isloading.postValue(true)
        val quote = getRandomQuoteUseCase()
        if(quote!=null){
            quoteModel.postValue(quote!!)
        }
        isloading.postValue(false)
    }




}