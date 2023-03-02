package com.example.livescoreapidemo.dataclasses.news

data class HomepageArticle(
    val articles: List<Article>,
    val category: Category,
    val meta: Meta
)