package com.example.livescoreapidemo.dataclasses.specificNews

data class Category(
    val active: Boolean,
    val created_at: String,
    val created_by: CreatedByXX,
    val description: Any,
    val entity_type: String,
    val generic: Any,
    val id: String,
    val main_media: List<Any>,
    val parent_id: Any,
    val seo: Seo,
    val subs: List<Any>,
    val title: String,
    val updated_at: String,
    val urls: Urls,
    val weight: Int
)