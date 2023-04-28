package com.curso.mvvm.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.curso.mvvm.domain.GetQuotesUseCase
import com.curso.mvvm.domain.GetRandomQuoteUseCase
import com.curso.mvvm.domain.model.Quote
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuoteViewModel @Inject constructor( // this class is prepared for be inject with dagger hill
    private val getQuotesUseCase: GetQuotesUseCase, // domain.GetQuotesUseCase (this is a inject)
    private val getRandomQuoteUseCase: GetRandomQuoteUseCase // domain.GetRandomQuoteUseCase (this is a inject)
) : ViewModel() {

    val quoteModel = MutableLiveData<Quote>() // save result api (all result is a list mutable)
    val isLoading = MutableLiveData<Boolean>() // active loading in layout, when wait result of server

    fun onCreate() {
        viewModelScope.launch {//auto kill task in the case coroutine freeze
            isLoading.postValue(true)//progress bar
            val result = getQuotesUseCase()

            if (!result.isNullOrEmpty()) {//if no null or empty TODO("in the case which server fail, never isLoading parse false, is need better")
                quoteModel.postValue(result[0])
                Log.i("QuoteViewModel", "result in quoteviewmodel = ${result[0]}, ${result[1]}, ${result[2]}" )
                //Log.i("btnapp", "Button Pulsado ${editName.text.toString()}")

                isLoading.postValue(false)// hide progress bar
            }
        }
    }

    fun randomQuote() { // Call the local save quote and apply Random, Simulate API consumption but is local, better performance, in project no need real time
        viewModelScope.launch {// coroutine automatically in case fail, not freeze app
            isLoading.postValue(true)
            val quote = getRandomQuoteUseCase()
            quote?.let {
                quoteModel.value = it
            }
            isLoading.postValue(false)
        }
    }
}