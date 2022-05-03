package com.checho.mvvm.data.network

import com.checho.mvvm.data.model.QuoteModel
import retrofit2.Response
import retrofit2.http.GET

interface QuoteApiClient {

    @GET("/.json")
    suspend fun gelAllQuotes():Response<List<QuoteModel>>
}