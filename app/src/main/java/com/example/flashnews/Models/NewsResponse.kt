package com.example.flashnews.Models

import com.example.flashnews.Models.Article

data class NewsResponse(
    val articles: MutableList<Article>,
    val status: String,
    val totalResults: Int
)