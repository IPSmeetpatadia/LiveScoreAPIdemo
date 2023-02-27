package com.example.livescoreapidemo.dataclasses.news

data class SeoX(
    val autoSlug: Boolean,
    val autoTitle: Boolean,
    val description: String,
    val follow: Boolean,
    val index: Boolean,
    val jsonld: Any,
    val keywords: List<Any>,
    val redirectType: Any,
    val slug: String,
    val title: String
)