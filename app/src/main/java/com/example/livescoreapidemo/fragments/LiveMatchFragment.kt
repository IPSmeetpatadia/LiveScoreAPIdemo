package com.example.livescoreapidemo.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.livescoreapidemo.R
import com.example.livescoreapidemo.adapters.LiveLeagueAdapter
import com.example.livescoreapidemo.dataclasses.livematches.ListLiveDataClass
import com.example.livescoreapidemo.interfaces.LiveMatchInterface
import kotlinx.android.synthetic.main.fragment_live_match.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*
import kotlin.math.abs

const val BASE_URL = "https://livescore6.p.rapidapi.com/matches/v2/"

class LiveMatchFragment : Fragment() {

    lateinit var liveMatchRecyclerView: RecyclerView
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
        liveMatchRecyclerView = recyclerview_liveScore
        liveMatchRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        getLiveMatchDetails()
    }

    private fun getLiveMatchDetails() {
        val urlBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(LiveMatchInterface::class.java)

        //TO GET TIMEZONE
        val tz: TimeZone = TimeZone.getDefault()
        val cal: Calendar = GregorianCalendar.getInstance(tz)
        val offsetInMillis: Int = tz.getOffset(cal.timeInMillis)
        val offset = String.format("%02d.%02d", abs(offsetInMillis / 3600000), abs(offsetInMillis / 60000 % 60))
        Log.d("TimeZone", "+${offset}")

        val liveData = urlBuilder.getLiveScore(
            "soccer",
            offset,
            "83e0bb9359mshf23a5e69a002769p129d96jsn8ed0c455bfcf",
            "livescore6.p.rapidapi.com"
        )

        liveData.enqueue(object : Callback<ListLiveDataClass?> {
            override fun onResponse(call: Call<ListLiveDataClass?>, response: Response<ListLiveDataClass?>) {
                val responseBody = response.body()!!
                liveMatches_progressBar.visibility = View.GONE
                liveMatchesAdapter = LiveLeagueAdapter(requireContext(), responseBody.Stages)
                liveMatchRecyclerView.adapter = liveMatchesAdapter
            }

            override fun onFailure(call: Call<ListLiveDataClass?>, t: Throwable) {
                Log.d("LIVE MATCH RESPONSE", "RESPONSE FAIL!!")
            }
        })
    }

}