package com.example.livescoreapidemo.dataclasses.specificNews

data class Seo(
    val description: String,
    val follow: Boolean,
    val index: Boolean,
    val keywords: List<Any>,
    val redirect_type: Any,
    val slug: String,
    val title: String
)