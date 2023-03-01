package com.example.livescoreapidemo.dataclasses.newsdetails

data class PublishedBy(
    val contactUrl: String,
    val logo: String,
    val logoSize: LogoSize,
    val name: String,
    val telephone: String,
    val websiteUrl: String
)