package com.example.livescoreapidemo.dataclasses.newsdetails

data class Meta(
    val canonical: String,
    val keywords: Any,
    val largeOgImage: String,
    val noFollow: Boolean,
    val noIndex: Boolean,
    val title: String
)