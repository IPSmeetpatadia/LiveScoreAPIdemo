package com.example.livescoreapidemo.dataclasses.newsdetails

data class CategoryX(
    val active: Boolean,
    val createdAt: String,
//    val createdBy: CreatedByXX,
    val description: String,
    val id: String,
    val initialTitle: String,
    val listPosition: Int,
    val media: List<Media>,
    val parentId: Any,
    val pathname: String,
    val seo: SeoXX,
    val subs: List<Any>,
    val title: String,
    val updatedAt: String
)