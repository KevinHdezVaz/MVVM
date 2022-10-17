package com.example.mvvm.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.example.mvvm.databinding.ActivityMainBinding
 import com.example.mvvm.ui.viewmodel.QuoteViewModel
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint

 @AndroidEntryPoint
 class MainActivity : AppCompatActivity() {
    private  lateinit var binding: ActivityMainBinding
    private val quoteViewModel: QuoteViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        quoteViewModel.onCreate()

        quoteViewModel.quoteModel.observe(this, Observer {
            binding.tvQuote.text = it.quote
            binding.tvAutor.text= it.author
        })
        quoteViewModel.isLoading.observe(this, Observer {
            binding.progressCircular.isVisible = it

        })
        binding.ViewContainer.setOnClickListener{

            quoteViewModel.randomQuote()
        }
    }
}