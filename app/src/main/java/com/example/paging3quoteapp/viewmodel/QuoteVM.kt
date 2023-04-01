package com.example.paging3quoteapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.paging3quoteapp.repository.QuoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class QuoteVM @Inject constructor(private val repository: QuoteRepository): ViewModel() {

    val list = repository.getQuotes().cachedIn(viewModelScope)
}