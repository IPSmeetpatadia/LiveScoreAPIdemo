package com.example.livescoreapidemo.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.livescoreapidemo.interfaces.LiveMatchInterface
import com.example.livescoreapidemo.R
import com.example.livescoreapidemo.adapter.LiveLeagueAdapter
import com.example.livescoreapidemo.dataclasses.livelist.ListLiveDataClass
import kotlinx.android.synthetic.main.fragment_live_match.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val LIVE_BASE_URL = "https://livescore6.p.rapidapi.com/matches/v2/"

class LiveMatchFragment : Fragment() {

    var liveMatchesAdapter: LiveLeagueAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_live_match, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerview_liveScore.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
//        getLiveMatchDetails()

    }

    private fun getLiveMatchDetails() {
        val urlBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(LIVE_BASE_URL)
            .build()
            .create(LiveMatchInterface::class.java)

        val liveData = urlBuilder.getLiveScore("soccer", 5, "83e0bb9359mshf23a5e69a002769p129d96jsn8ed0c455bfcf", "livescore6.p.rapidapi.com")


        liveData.enqueue(object : Callback<ListLiveDataClass?> {

            override fun onResponse(call: Call<ListLiveDataClass?>, response: Response<ListLiveDataClass?>) {
                val responseBody = response.body()!!

                liveMatchesAdapter = LiveLeagueAdapter(requireContext(), responseBody.Stages)
                recyclerview_liveScore.adapter  = liveMatchesAdapter
            }

            override fun onFailure(call: Call<ListLiveDataClass?>, t: Throwable) {
                Log.d("LIVE MATCH RESPONSE", "RESPONSE FAIL!!")
            }
        })
    }
}