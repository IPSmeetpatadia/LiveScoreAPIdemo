package com.example.livescoreapidemo.dataclasses.newsdetails

data class Author(
    val active: Boolean,
    val avatar_url: Any,
    val bio: Any,
    val created_at: String,
    val created_by: CreatedBy,
    val default: Boolean,
    val entity_type: String,
    val generic: Any,
    val id: String,
    val name: String,
    val seo: Any,
    val updated_at: String,
    val weight: Int
)