package com.example.livescoreapidemo.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.livescoreapidemo.R
import com.example.livescoreapidemo.dataclasses.news.Article
import com.example.livescoreapidemo.dataclasses.news.HomepageArticle
import kotlinx.android.synthetic.main.single_view_home_article.view.*

class HomeArticleNewsAdapter(val context: Context, val homeArticleList: List<Article>): RecyclerView.Adapter<HomeArticleNewsAdapter.ArticleViewHolder>() {

    class ArticleViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val article_img: ImageView = itemView.imgV_homeArticleImg
        val article_title: TextView = itemView.txt_articleTitle
        val article_tags: RecyclerView = itemView.recyclerView_articleTags
        val article_timing: TextView = itemView.txt_articleTiming
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.single_view_home_article, parent, false)
        return ArticleViewHolder(view)
    }

    override fun getItemCount(): Int {
        return homeArticleList.size
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        holder.apply {
            var str:String = ""
            if (homeArticleList[position].updatedAt.unit == "news.minutes")
            {
                str = " minute"
            } else if (homeArticleList[position].updatedAt.unit == "news.hours") {
                str = " hours"
            } else if (homeArticleList[position].updatedAt.unit == "news.hour") {
                str = " hour"
            }
            else if ((homeArticleList[position].updatedAt.unit == "news.day" || homeArticleList[position].updatedAt.unit == "news.days") && (homeArticleList[position].updatedAt.time > 1.toString())) {
                str = " Days ago"
            } else if ((homeArticleList[position].updatedAt.unit == "news.day" || homeArticleList[position].updatedAt.unit == "news.days") && (homeArticleList[position].updatedAt.time == 1.toString())) {
                str = " Day ago"
            } else if ((homeArticleList[position].updatedAt.unit == "news.week" || homeArticleList[position].updatedAt.unit == "news.weeks") && (homeArticleList[position].updatedAt.time > 1.toString())) {
                str = " Weeks ago"
            } else if ((homeArticleList[position].updatedAt.unit == "news.week" || homeArticleList[position].updatedAt.unit == "news.weeks") && (homeArticleList[position].updatedAt.time == 1.toString())) {
                str = " Week ago"
            }
            Glide.with(context).load(homeArticleList[position].mainMedia.gallery.url).into(article_img)
            article_title.text = homeArticleList[position].title
            article_timing.text = homeArticleList[position].updatedAt.time + str
        }
    }
}