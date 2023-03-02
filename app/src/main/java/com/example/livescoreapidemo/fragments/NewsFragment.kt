package com.example.livescoreapidemo.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.livescoreapidemo.R
import com.example.livescoreapidemo.activities.MainActivity
import com.example.livescoreapidemo.adapters.HomeArticleTitleAdapter
import com.example.livescoreapidemo.adapters.NewsAdapter
import com.example.livescoreapidemo.adapters.NewsCategoryAdapter
import com.example.livescoreapidemo.adapters.NewsSpecificAdapter
import com.example.livescoreapidemo.dataclasses.news.Category
import com.example.livescoreapidemo.dataclasses.news.NewsList
import com.example.livescoreapidemo.dataclasses.specificNews.Data
import com.example.livescoreapidemo.dataclasses.specificNews.SpecificNews
import com.example.livescoreapidemo.interfaces.NewsInterface
import com.example.livescoreapidemo.interfaces.SpecificNewsInterface
import kotlinx.android.synthetic.main.fragment_news.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val NEWS_BASE_URL = "https://livescore6.p.rapidapi.com/news/"
class NewsFragment : Fragment() {

    lateinit var newsCategoryRecyclerView: RecyclerView
    lateinit var newsRecyclerView: RecyclerView
    lateinit var articleRecyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getNews()
        getHomeArticles()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        newsCategoryRecyclerView = newsHorizontalRecyclerView
        newsCategoryRecyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        newsRecyclerView = newsVerticalRecyclerView
        newsRecyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        newsRecyclerView.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))      //adding separation line between each item

        articleRecyclerView = recyclerView_homeArticles
        articleRecyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        articleRecyclerView.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
    }

    private fun getNews() {
        //CATEGORY LIST
        val urlBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(NEWS_BASE_URL)
            .build()
            .create(NewsInterface::class.java)

        val newsCategory = urlBuilder.getNewsList("83e0bb9359mshf23a5e69a002769p129d96jsn8ed0c455bfcf", "livescore6.p.rapidapi.com")

        newsCategory.enqueue(object : Callback<NewsList?> {
            override fun onResponse(call: Call<NewsList?>, response: Response<NewsList?>) {
                val responseBody = response.body()
                news_progressBar.visibility = View.GONE

                newsRecyclerView.adapter = NewsAdapter(requireContext(), responseBody!!.topStories)

                newsCategoryRecyclerView.adapter = NewsCategoryAdapter(requireContext(), responseBody!!.categories, object : NewsCategoryAdapter.OnCategoryClick{
                    override fun clickedCategories(category: Category) {
                        //  LOADING NEWS ACCORDINGLY SELECTED CATEGORY
                        newsRecyclerView.adapter = null
                        articleRecyclerView.adapter = null
                        news_progressBar.visibility = View.VISIBLE
                        val newURL = Retrofit.Builder()
                            .baseUrl(NEWS_BASE_URL)
                            .addConverterFactory(GsonConverterFactory.create())
                            .build()
                            .create(SpecificNewsInterface::class.java)

                        newURL.getSpecificNews(category.id, "83e0bb9359mshf23a5e69a002769p129d96jsn8ed0c455bfcf", "livescore6.p.rapidapi.com")

                            .enqueue(object : Callback<SpecificNews?> {
                                override fun onResponse(call: Call<SpecificNews?>, response: Response<SpecificNews?>) {
                                    val responseBody1 = response.body()
                                    news_progressBar.visibility = View.GONE

                                    newsRecyclerView.adapter = NewsSpecificAdapter(requireContext(), responseBody1!!.data,
                                    object : NewsSpecificAdapter.OnNewsClick {
                                        //LOADING DETAIL NEWS FRAGMENT, ON CLICK OF ITEM
                                        override fun clickedNews(data: Data) {
                                            (activity as MainActivity).supportFragmentManager.beginTransaction().replace(R.id.layout_mainActivity, DetailedNewsFragment(data)).addToBackStack(null).commit()
                                        }
                                    })

                                    //when we click specific category, home article should not be visible
                                    articleRecyclerView.adapter = null
                                }

                                override fun onFailure(call: Call<SpecificNews?>, t: Throwable) {
                                    Log.d("NEWS-CATEGORY RESPONSE", "RESPONSE FAIL!!")
                                }
                            })
                    }
                })
            }

            override fun onFailure(call: Call<NewsList?>, t: Throwable) {
                Log.d("NEWS-LIST RESPONSE", "RESPONSE FAIL!!")
            }
        })
    }

    private fun getHomeArticles() {
        val articleUrl = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(NEWS_BASE_URL)
            .build()
            .create(NewsInterface::class.java)

        articleUrl.getNewsList("83e0bb9359mshf23a5e69a002769p129d96jsn8ed0c455bfcf", "livescore6.p.rapidapi.com")
            .enqueue(object : Callback<NewsList?> {
                override fun onResponse(call: Call<NewsList?>, response: Response<NewsList?>) {
                    val responseBody = response.body()

                    articleRecyclerView.adapter = HomeArticleTitleAdapter(requireContext(), responseBody!!.homepageArticles,
                    object : HomeArticleTitleAdapter.OnArticleCategoryClick{
                        override fun clickedArticleCategories(category: Category) {
                            newsRecyclerView.adapter = null
                            articleRecyclerView.adapter = null
                            news_progressBar.visibility = View.VISIBLE
                            val newURL = Retrofit.Builder()
                                .baseUrl(NEWS_BASE_URL)
                                .addConverterFactory(GsonConverterFactory.create())
                                .build()
                                .create(SpecificNewsInterface::class.java)

                            newURL.getSpecificNews(category.id, "83e0bb9359mshf23a5e69a002769p129d96jsn8ed0c455bfcf", "livescore6.p.rapidapi.com")

                                .enqueue(object : Callback<SpecificNews?> {
                                    override fun onResponse(call: Call<SpecificNews?>, response: Response<SpecificNews?>) {
                                        val responseBody1 = response.body()
                                        news_progressBar.visibility = View.GONE

                                        newsRecyclerView.adapter = NewsSpecificAdapter(requireContext(), responseBody1!!.data,
                                            object : NewsSpecificAdapter.OnNewsClick {
                                                //LOADING DETAIL NEWS FRAGMENT, ON CLICK OF ITEM
                                                override fun clickedNews(data: Data) {
                                                    (activity as MainActivity).supportFragmentManager.beginTransaction().replace(R.id.layout_mainActivity, DetailedNewsFragment(data)).addToBackStack(null).commit()
                                                }
                                            })

                                        //when we click specific category, home article should not be visible
                                        articleRecyclerView.adapter = null
                                    }

                                    override fun onFailure(call: Call<SpecificNews?>, t: Throwable) {
                                        Log.d("NEWS-CATEGORY RESPONSE", "RESPONSE FAIL!!")
                                    }
                                })
                        }
                    })
                }

                override fun onFailure(call: Call<NewsList?>, t: Throwable) {
                    Log.d("HOME ARTICLE TITLE", "RESPONSE FAIL")
                }
            })
    }

}


