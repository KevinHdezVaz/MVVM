package com.example.mvvm.data.database.entities.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mvvm.data.database.entities.QuoteEntiti


@Dao
interface QuoteDao {

    //query para llamar todas las citas
@Query("SELECT  * FROM quote_table ORDER BY author DESC")
suspend fun getCallQuotes(): List<QuoteEntiti>


//query para hacer excepciones o conflicto
@Insert(onConflict = OnConflictStrategy.REPLACE)
suspend fun insertAll (quotes: List<QuoteEntiti>)


@Query ("DELETE FROM quote_table")
suspend fun deleteAllQuotes()
 }