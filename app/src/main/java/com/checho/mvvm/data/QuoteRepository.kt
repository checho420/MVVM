package com.checho.mvvm.data

import com.checho.mvvm.data.model.QuoteModel
import com.checho.mvvm.data.model.QuoteProvider
import com.checho.mvvm.data.network.QuoteService

class QuoteRepository {

    private val api = QuoteService()

    suspend fun getAllQuotes(): List<QuoteModel> {
        var response: List<QuoteModel> = api.getQuotes()
        QuoteProvider.quotes = response
        return response
    }
}