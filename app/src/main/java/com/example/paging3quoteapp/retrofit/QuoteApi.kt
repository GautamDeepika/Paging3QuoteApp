package com.example.paging3quoteapp.retrofit

import com.example.paging3quoteapp.models.QuoteList
import retrofit2.http.GET
import retrofit2.http.Query

interface QuoteApi {

    @GET("/quotes")
    suspend fun getQuotes(@Query("page") page: Int): QuoteList
}