package com.example.livescoreapidemo.dataclasses.newsdetails

data class AdsTargeting(
    val adUnitPathName: String,
    val category: String,
    val environment: String,
    val newsArticleCategory: String,
    val newsArticleId: String,
    val newsArticleLeague: Any,
    val newsArticleSensitiveContent: Boolean,
    val newsArticleTags: Any,
    val newsArticleTeam: Any,
    val newsArticleTitle: String,
    val screen: String
)