package com.example.flashnews.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.flashnews.NewsActivity
import com.example.flashnews.R
import com.example.flashnews.databinding.FragmentArticleBinding
import com.example.flashnews.ui.NewsViewModel
import com.google.android.material.snackbar.Snackbar

class ArticleFragment:Fragment(R.layout.fragment_article) {
    private var _binding: FragmentArticleBinding? = null
    private val binding get() = _binding!!

    lateinit var viewModel: NewsViewModel
    val args:ArticleFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentArticleBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel=(activity as NewsActivity).viewModel
        val article=args.article
        binding.webView.apply {
            webViewClient= WebViewClient()
            article.url?.let { loadUrl(it) }
        }
        binding.fab.setOnClickListener {
            viewModel.saveArticle(article)
            Snackbar.make(view,"Article Saved Successfully", Snackbar.LENGTH_SHORT).show()
        }
    }
}