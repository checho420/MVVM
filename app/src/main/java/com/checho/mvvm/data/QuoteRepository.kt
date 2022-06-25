package com.checho.mvvm.data

import com.checho.mvvm.data.model.QuoteModel
import com.checho.mvvm.data.model.QuoteProvider
import com.checho.mvvm.data.network.QuoteService
import javax.inject.Inject

class QuoteRepository @Inject constructor(
    private val api: QuoteService,
    private val quoteProvider: QuoteProvider
) {

    suspend fun getAllQuotes(): List<QuoteModel> {
        var response: List<QuoteModel> = api.getQuotes()
        quoteProvider.quotes = response
        return response
    }
}