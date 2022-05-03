package com.checho.mvvm.domain

import com.checho.mvvm.data.QuoteRepository
import com.checho.mvvm.data.model.QuoteModel

class GetQuotesUseCase {

    private val repository = QuoteRepository()
    suspend operator fun invoke(): List<QuoteModel>? = repository.getAllQuotes()

}