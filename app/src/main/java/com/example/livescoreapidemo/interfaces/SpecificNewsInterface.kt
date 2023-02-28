package com.example.livescoreapidemo.interfaces

import com.example.livescoreapidemo.dataclasses.specificNews.SpecificNews
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface SpecificNewsInterface {

    @GET("v2/list-by-sport")
    fun getSpecificNews(
        @Query("category") SportCategory: String,
        @Header("X-RapidAPI-Key") apiKey: String,
        @Header("X-RapidAPI-Host") apiHost: String
    ): Call<SpecificNews>

}