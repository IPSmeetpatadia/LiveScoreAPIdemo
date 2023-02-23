package com.example.livescoreapidemo.interfaces

import com.example.livescoreapidemo.dataclasses.livelist.ListLiveDataClass
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface LiveMatchInterface {

    @GET("list-live")
    fun getLiveScore(
        @Query("Category") category: String,
        @Query("Timezone") timeZone: Int,
        @Header("X-RapidAPI-Key") apiKey: String,
        @Header("X-RapidAPI-Host") apiHost: String
    ): Call<ListLiveDataClass>

}