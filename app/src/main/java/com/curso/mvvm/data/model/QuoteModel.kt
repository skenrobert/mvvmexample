package com.curso.mvvm.data.model

import com.google.gson.annotations.SerializedName

data class QuoteModel( //TODO: Information get retrofit for api convert in this class
    @SerializedName("quote") val quote: String,
    @SerializedName("author") val author: String
)