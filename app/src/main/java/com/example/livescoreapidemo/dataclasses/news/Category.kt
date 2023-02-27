package com.example.livescoreapidemo.dataclasses.news

data class Category(
    val active: Boolean,
    val createdAt: String,
    val createdBy: CreatedBy,
    val description: String,
    val id: String,
    val initialTitle: String,
    val listPosition: Int,
    val media: List<Media>,
    val parentId: Any,
    val pathname: String,
    val seo: Seo,
    val subs: List<Any>,
    val title: String,
    val updatedAt: String
)