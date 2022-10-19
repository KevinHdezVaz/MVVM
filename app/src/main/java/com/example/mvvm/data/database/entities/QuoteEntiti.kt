package com.example.mvvm.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.mvvm.domain.model.Quote


@Entity(tableName = "quote_table")
data class QuoteEntiti (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int= 0,
    @ColumnInfo(name ="quote" ) val quote:String ,
    @ColumnInfo(name ="author" ) val author: String)

fun Quote.todatabase() = QuoteEntiti(quote = quote, author = author)