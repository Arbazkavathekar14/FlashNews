package com.example.flashnews.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.flashnews.Models.Article
import com.example.flashnews.R

class NewsAdapter : RecyclerView.Adapter<NewsAdapter.ArticleViewHolder>() {

    inner class ArticleViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var ivArticleImage: ImageView =itemView.findViewById(R.id.ivArticleImage)
        var tvSource: TextView =itemView.findViewById(R.id.tvSource)
        var tvTitle: TextView =itemView.findViewById(R.id.tvTitle)
        var tvDescription: TextView =itemView.findViewById(R.id.tvDescription)
        var tvPublishedAt: TextView =itemView.findViewById(R.id.tvPublishedAt)


    }

    private val differCallback= object: DiffUtil.ItemCallback<Article>(){
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem.url==newItem.url
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem == newItem
        }
    }
    val differ= AsyncListDiffer(this,differCallback)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        return ArticleViewHolder(
            LayoutInflater.from(parent.context).inflate
            (R.layout.item_article_preview,parent,false ))
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {

        val article=differ.currentList[position]
        holder.itemView.apply {
            Glide.with(this).load(article.urlToImage).into(holder.ivArticleImage)
            holder.tvSource.text=article.source?.name
            holder.tvTitle.text=article.title
            holder.tvDescription.text=article.description
            holder.tvPublishedAt.text=article.publishedAt
            setOnClickListener {
                onItemClickListener?.let { it(article) }
            }
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }
    private var onItemClickListener :((Article)->Unit)?=null

    fun setOnItemClickListener(listener :(Article)->Unit){
        onItemClickListener=listener
    }
}