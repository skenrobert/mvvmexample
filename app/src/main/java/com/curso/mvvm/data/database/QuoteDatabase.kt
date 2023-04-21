package com.curso.mvvm.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.curso.mvvm.data.database.dao.QuoteDao
import com.curso.mvvm.data.database.entities.QuoteEntity

@Database(entities = [QuoteEntity::class], version = 1)
abstract class QuoteDatabase: RoomDatabase() {

    abstract fun getQuoteDao():QuoteDao
}