package com.example.livescoreapidemo.dataclasses.news

data class Media(
    val `data`: Any,
    val description: String,
    val provider: String,
    val resource_id: String,
    val resource_subtype: String,
    val resource_type: String
)