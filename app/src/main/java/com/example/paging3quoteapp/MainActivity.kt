package com.example.paging3quoteapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.paging3quoteapp.paging.QuotePagingAdapter
import com.example.paging3quoteapp.viewmodel.QuoteVM
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var quoteVM: QuoteVM
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: QuotePagingAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.rvQuoteList)
        quoteVM = ViewModelProvider(this).get(QuoteVM::class.java)
        adapter = QuotePagingAdapter()

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adapter

        quoteVM.list.observe(this, Observer {
            adapter.submitData(lifecycle, it)
        })
    }
}