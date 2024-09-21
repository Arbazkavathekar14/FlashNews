package com.example.flashnews.api

import com.example.flashnews.Models.NewsResponse
import com.example.flashnews.util.Constants.Companion.Api_key
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("v2/top-headlines")
    suspend fun getBreakingNews(
        @Query("country")
        countryCode :String ="us",
        @Query("page")
        pageNumber :Int =1,
        @Query("apiKey")
        apiKey:String=Api_key
    ): Response<NewsResponse>

    @GET("v2/top-everything")
    suspend fun searchForNews(
        @Query("q")
        searchQuery:String,
        @Query("page")
        pageNumber :Int =1,
        @Query("apiKey")
        apiKey:String=Api_key
    ): Response<NewsResponse>
}