package com.checho.mvvm.data.network

import com.checho.mvvm.core.RetrofitHelper
import com.checho.mvvm.data.model.QuoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject


class QuoteService @Inject constructor(private val api: QuoteApiClient) {

    suspend fun getQuotes(): List<QuoteModel> {
        return withContext(Dispatchers.IO) {
            val response = api.gelAllQuotes()
            response.body() ?: emptyList()
        }
    }
}