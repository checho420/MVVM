package com.checho.mvvm.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.checho.mvvm.data.model.QuoteModel
import com.checho.mvvm.data.model.QuoteProvider
import com.checho.mvvm.domain.GetQuotesUseCase
import com.checho.mvvm.domain.GetRandomQuoteUseCase
import kotlinx.coroutines.launch

class QuoteViewModel : ViewModel() {

    val quoteModel = MutableLiveData<QuoteModel>()
    val isLoading = MutableLiveData<Boolean>()

    var getQuotesUseCase = GetQuotesUseCase()
    var getRansomQuotesUseCase = GetRandomQuoteUseCase()

    fun onCreate() {

        viewModelScope.launch {
            isLoading.postValue(true)
            val result: List<QuoteModel>? = getQuotesUseCase()

            if (!result.isNullOrEmpty()) {
                quoteModel.postValue(result[0])
                isLoading.postValue(true)
            }

        }
    }

    fun randomQuote() {
        isLoading.postValue(true)

        val quote: QuoteModel? = getRansomQuotesUseCase()
        if (quote != null) {
            quoteModel.postValue(quote)
        }

        isLoading.postValue(false)


        /*

        val currentQuote: QuoteModel = QuoteProvider.random()
        quoteModel.postValue(currentQuote)

         */
    }


}