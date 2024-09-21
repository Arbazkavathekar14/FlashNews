package com.example.flashnews.Repository

import com.example.flashnews.Models.Article
import com.example.flashnews.api.RetrofitInstance
import com.example.flashnews.database.ArticleDatabase

class NewsRepository(
    val db : ArticleDatabase
) {
    suspend fun getBreakingNews(country:String,page:Int)=
        RetrofitInstance.api.getBreakingNews(country,page)

    suspend fun searchNews(searchQuery:String,page:Int)=
        RetrofitInstance.api.searchForNews(searchQuery,page)

    suspend fun  upsert(article: Article)=db.getArticleDao().upsert(article)

    fun getSavedNews ()=db.getArticleDao().getAllArticles()

    suspend fun deleteArticle(article: Article)=db.getArticleDao().deleteArticle(article)


}