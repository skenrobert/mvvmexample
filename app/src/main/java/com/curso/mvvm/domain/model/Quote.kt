package com.curso.mvvm.domain.model

import com.curso.mvvm.data.database.entities.QuoteEntity
import com.curso.mvvm.data.model.QuoteModel

data class Quote (val quote:String, val author:String) //model data main, for UI and domain (recommend change name function for QuoteModelDomain)

fun QuoteModel.toDomain() = Quote(quote, author) // mapper transformer all date (this is a function extension)
fun QuoteEntity.toDomain() = Quote(quote, author) // access id with need you