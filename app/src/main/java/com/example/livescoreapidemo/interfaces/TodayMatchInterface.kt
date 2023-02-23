package com.example.livescoreapidemo.interfaces

import com.example.livescoreapidemo.dataclass.todaymatches.TodayMatchesDataClass
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query


interface TodayMatchInterface {

    @GET("list-by-date")
    fun getTodayMatches(
        @Query("Category") category: String,
        @Query("Date") Date: String,
        @Header("X-RapidAPI-Key") apiKey: String,
        @Header("X-RapidAPI-Host") apiHost: String
    ): Call<TodayMatchesDataClass>
}