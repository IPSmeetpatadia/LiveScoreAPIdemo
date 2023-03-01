package com.example.livescoreapidemo.dataclasses.newsdetails

data class RelatedArticle(
    val categoryLabel: String,
    val categoryUrl: String,
    val id: String,
    val isAdultContent: Boolean,
    val mainMedia: MainMediaX,
    val publishedAt: String,
    val publishedRegions: List<Any>,
    val related: Any,
    val shortTitle: Any,
    val title: String,
    val type: Any,
    val updatedAt: UpdatedAtX,
    val url: String
)