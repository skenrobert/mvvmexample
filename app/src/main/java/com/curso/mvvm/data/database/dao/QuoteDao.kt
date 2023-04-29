package com.curso.mvvm.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.curso.mvvm.data.database.entities.QuoteEntity

@Dao
interface QuoteDao { // data access object, implement consult with dependency room

    @Query("SELECT * FROM quote_table ORDER BY author DESC") // get all quote
    suspend fun getAllQuotes():List<QuoteEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE) // insert all quote
    suspend fun insertAll(quotes:List<QuoteEntity>)

    @Query("DELETE FROM quote_table")// delete all quote, call for repository
    suspend fun deleteAllQuotes()
}