package com.example.livescoreapidemo.interfaces

import com.example.livescoreapidemo.dataclasses.newsdetails.NewsDetails
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface NewsDetailInterface {

    @GET("v2/detail")
    fun getSportDetail(
        @Query("id") Id: String,
        @Header("X-RapidAPI-Key") apiKey: String,
        @Header("X-RapidAPI-Host") apiHost: String
    ): Call<NewsDetails>

}