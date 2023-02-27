package com.example.livescoreapidemo.interfaces

import com.example.livescoreapidemo.dataclasses.news.NewsList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface NewsInterface {

    @GET("v2/list/")
    fun getNewsList(
        @Header("X-RapidAPI-Key") apiKey: String,
        @Header("X-RapidAPI-Host") apiHost: String
    ): Call<NewsList>

}