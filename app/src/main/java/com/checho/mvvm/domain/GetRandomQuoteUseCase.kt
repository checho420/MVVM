package com.checho.mvvm.domain

import com.checho.mvvm.data.model.QuoteModel
import com.checho.mvvm.data.model.QuoteProvider

class GetRandomQuoteUseCase {

    operator fun invoke(): QuoteModel? {
        val quotes: List<QuoteModel> = QuoteProvider.quotes

        if (!quotes.isNullOrEmpty()) {
            val randomNumeber: Int = (0..quotes.size - 1).random()
            return quotes[randomNumeber]
        }
        return null
    }
}