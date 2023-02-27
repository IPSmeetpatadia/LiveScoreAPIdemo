package com.example.livescoreapidemo.dataclasses.news

data class HomepageArticle(
    val articles: List<Article>,
    val category: CategoryX,
    val meta: Meta
)