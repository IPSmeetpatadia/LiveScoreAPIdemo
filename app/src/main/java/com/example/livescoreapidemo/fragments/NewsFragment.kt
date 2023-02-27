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
import com.example.livescoreapidemo.adapter.NewsAdapter
import com.example.livescoreapidemo.dataclasses.news.NewsList
import com.example.livescoreapidemo.interfaces.NewsInterface
import kotlinx.android.synthetic.main.fragment_news.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val NEWS_BASE_URL = "https://livescore6.p.rapidapi.com/news/"

class NewsFragment : Fragment() {

    lateinit var newsRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        newsRecyclerView = newsHorizontalRecyclerView
        newsRecyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        getNews()
    }

    private fun getNews() {
        val urlBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(NEWS_BASE_URL)
            .build()
            .create(NewsInterface::class.java)

        val newsData = urlBuilder.getNewsList("83e0bb9359mshf23a5e69a002769p129d96jsn8ed0c455bfcf", "livescore6.p.rapidapi.com")

        newsData.enqueue(object : Callback<NewsList?> {
            override fun onResponse(call: Call<NewsList?>, response: Response<NewsList?>) {
                val responseBody = response.body()
                newsRecyclerView.adapter = NewsAdapter(requireContext(), responseBody!!.categories)
            }

            override fun onFailure(call: Call<NewsList?>, t: Throwable) {
                Log.d("NEWS RESPONSE", "RESPONSE FAIL!!")
            }
        })


    }


}