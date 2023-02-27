package com.example.livescoreapidemo.dataclasses.news

data class Seo(
    val description: String,
    val follow: Boolean,
    val index: Boolean,
    val jsonld: Any,
    val keywords: List<Any>,
    val redirect_type: Any,
    val slug: String,
    val title: String
)