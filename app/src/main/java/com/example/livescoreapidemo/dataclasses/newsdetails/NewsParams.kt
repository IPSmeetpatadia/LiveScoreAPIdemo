package com.example.livescoreapidemo.dataclasses.newsdetails

data class NewsParams(
    val mediaCategory: String,
    val newsArticleUrl: String,
    val oddsWidgetIsPresent: Boolean
)