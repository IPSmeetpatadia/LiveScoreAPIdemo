package com.example.livescoreapidemo.dataclasses.news

data class TopStory(
    val categoryLabel: String,
    val categoryUrl: String,
    val id: String,
    val isAdultContent: Boolean,
    val mainMedia: MainMediaXX,
    val publishedAt: String,
    val publishedRegions: List<Any>,
    val related: Any,
    val shortTitle: Any,
    val title: String,
    val type: String,
    val updatedAt: UpdatedAt,
    val url: String
)