package com.example.workmanagertestapplication.network

import com.example.workmanagertestapplication.database.QuoteTable

data class Quote(
    val _id: String,
    val author: String,
    val authorSlug: String,
    val content: String,
    val dateAdded: String,
    val dateModified: String,
    val length: Int,
    val tags: List<String>
){

    fun Quote.toQuoteTable() : QuoteTable {
        return QuoteTable(
            quote = content,
            key = 1
        )
    }
}

