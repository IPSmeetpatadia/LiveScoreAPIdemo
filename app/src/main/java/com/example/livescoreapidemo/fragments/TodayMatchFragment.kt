package com.example.livescoreapidemo.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.livescoreapidemo.R
import com.example.livescoreapidemo.adapters.TodayLeagueAdapter
import com.example.livescoreapidemo.dataclasses.todaymatches.TodayMatchesDataClass
import com.example.livescoreapidemo.interfaces.TodayMatchInterface
import kotlinx.android.synthetic.main.fragment_today_match.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.text.SimpleDateFormat
import java.util.*

class TodayMatchFragment : Fragment() {

    lateinit var todayMatchRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_today_match, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        todayMatchRecyclerView = recyclerview_todayMatches
        todayMatchRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        getTodayMatchList()
    }

    private fun getTodayMatchList() {
        val urlBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(TodayMatchInterface::class.java)

        val matchData = urlBuilder.getTodayMatches(
            "soccer",
            SimpleDateFormat("yyyyMMdd", Locale.getDefault()).format(Date()),       //to get today's date in `yyyyMMdd` format
            "83e0bb9359mshf23a5e69a002769p129d96jsn8ed0c455bfcf",
            "livescore6.p.rapidapi.com"
        )

        matchData.enqueue(object : Callback<TodayMatchesDataClass?> {
            override fun onResponse(call: Call<TodayMatchesDataClass?>, response: Response<TodayMatchesDataClass?>) {
                val responseBody = response.body()!!
                todayMatches_progressBar.visibility = View.GONE
                todayMatchRecyclerView.adapter = TodayLeagueAdapter(requireContext(), responseBody.Stages)
            }

            override fun onFailure(call: Call<TodayMatchesDataClass?>, t: Throwable) {
                Log.d("TODAY MATCH RESPONSE", "RESPONSE FAIL!!")
            }
        })
    }

}

