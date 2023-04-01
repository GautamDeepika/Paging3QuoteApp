package com.example.paging3quoteapp.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.example.paging3quoteapp.paging.QuotePagingSource
import com.example.paging3quoteapp.retrofit.QuoteApi
import javax.inject.Inject

class QuoteRepository @Inject constructor(private val quoteApi: QuoteApi) {

    fun getQuotes() = Pager(
        config = PagingConfig(pageSize = 10, maxSize = 100),
        pagingSourceFactory = { QuotePagingSource(quoteApi) }
    ).liveData
}