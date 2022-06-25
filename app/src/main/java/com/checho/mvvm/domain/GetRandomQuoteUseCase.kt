package com.checho.mvvm.domain

import com.checho.mvvm.data.model.QuoteModel
import com.checho.mvvm.data.model.QuoteProvider
import javax.inject.Inject

class GetRandomQuoteUseCase @Inject constructor(private val quoteProvider: QuoteProvider) {

    operator fun invoke(): QuoteModel? {
        val quotes: List<QuoteModel> = quoteProvider.quotes
        if (!quotes.isNullOrEmpty()) {
            val randomNumeber: Int = (0..quotes.size - 1).random()
            return quotes[randomNumeber]
        }
        return null
    }
}