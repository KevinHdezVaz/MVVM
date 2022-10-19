package com.example.mvvm.data.database.entities

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mvvm.data.database.entities.dao.QuoteDao

@Database(entities = [QuoteEntiti::class], version = 1)
abstract class QuoteDatabase :RoomDatabase(){

    abstract fun getQuoteDao():QuoteDao




}