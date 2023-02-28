package com.example.livescoreapidemo.dataclasses.specificNews

data class Owner(
    val created_at: String,
//    val created_by: CreatedByXXXXX,
    val default: Boolean,
    val description: Any,
    val id: String,
    val name: String,
    val slug: String,
    val updated_at: String
)