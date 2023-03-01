package com.example.livescoreapidemo.dataclasses.newsdetails

data class Category(
    val active: Boolean,
    val createdAt: String,
    val createdBy: CreatedByX,
    val description: Any,
    val id: String,
    val initialTitle: String,
    val listPosition: Int,
    val media: List<Any>,
    val parentId: Any,
    val pathname: String,
    val seo: Seo,
    val subs: List<Any>,
    val title: String,
    val updatedAt: String
)