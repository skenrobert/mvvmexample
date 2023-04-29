package com.curso.mvvm.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.curso.mvvm.domain.model.Quote

@Entity(tableName = "quote_table")// name table data base
data class QuoteEntity( // Object for work room dependencies, this class is other layer of QuoteModel
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "quote") val quote: String,
    @ColumnInfo(name = "author") val author: String
)


fun Quote.toDatabase() = QuoteEntity(quote = quote, author =  author) //mapper for repository