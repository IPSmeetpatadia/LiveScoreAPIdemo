package com.example.livescoreapidemo.dataclasses.newsdetails

data class Related(
    val relatedArticles: List<RelatedArticle>,
    val tags: List<Any>
)