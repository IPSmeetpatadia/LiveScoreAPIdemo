package com.example.livescoreapidemo.fragments

import android.os.Bundle
import android.text.Html
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.livescoreapidemo.R
import com.example.livescoreapidemo.dataclasses.newsdetails.NewsDetails
import com.example.livescoreapidemo.dataclasses.specificNews.Data
import com.example.livescoreapidemo.interfaces.NewsDetailInterface
import kotlinx.android.synthetic.main.fragment_detailed_news.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DetailedNewsFragment(val data: Data) : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detailed_news, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getNewsDetails()
    }

    private fun getNewsDetails() {

                val imgV = view?.findViewById<ImageView>(R.id.imgV_detailedNewsImg)

        val urlBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(NEWS_BASE_URL)
            .build()
            .create(NewsDetailInterface::class.java)

        val newsDetail = urlBuilder.getSportDetail(data.id, "83e0bb9359mshf23a5e69a002769p129d96jsn8ed0c455bfcf", "livescore6.p.rapidapi.com")

        newsDetail.enqueue(object : Callback<NewsDetails?> {
            override fun onResponse(call: Call<NewsDetails?>, response: Response<NewsDetails?>) {
                val responseBody = response.body()

                txt_detailedNewsHeadline.text = responseBody!!.adsTargeting.newsArticleTitle
                Glide.with(context!!).load(responseBody.article.mainMedia.gallery.url).into(imgV!!)
                txt_newsSubTxt.text = responseBody.article.mainMedia.gallery.alt
                val stringBuilder = StringBuilder()
                for (i in responseBody.article.body.indices) {
                    stringBuilder.append(responseBody.article.body[i].data.content+"\n\n")
                }
                txt_newsDetails.setText(Html.fromHtml(stringBuilder.toString()))

            }

            override fun onFailure(call: Call<NewsDetails?>, t: Throwable) {

            }
        })
    }
}