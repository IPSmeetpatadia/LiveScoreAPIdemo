package com.example.livescoreapidemo.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.livescoreapidemo.R
import com.example.livescoreapidemo.dataclasses.news.Category
import com.example.livescoreapidemo.dataclasses.news.HomepageArticle
import kotlinx.android.synthetic.main.single_view_home_article_title.view.*

class HomeArticleTitleAdapter(val context: Context, val articleTitleList: List<HomepageArticle>, val listener: OnArticleCategoryClick)
    : RecyclerView.Adapter<HomeArticleTitleAdapter.ArticleTitleViewHolder>() {

    class ArticleTitleViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val article_title: TextView = itemView.txt_homeArticleTitle
        val recyclerView_article: RecyclerView = itemView.recyclerView_homeArticles_news
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleTitleViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.single_view_home_article_title, parent, false)
        return ArticleTitleViewHolder(view)
    }

    override fun getItemCount(): Int {
        return articleTitleList.size
    }

    override fun onBindViewHolder(holder: ArticleTitleViewHolder, position: Int) {
        holder.apply {
            article_title.text = articleTitleList[position].category.initialTitle + " news"

            recyclerView_article.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            recyclerView_article.adapter = HomeArticleNewsAdapter(context, articleTitleList[position].articles)
            recyclerView_article.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))

            itemView.setOnClickListener {
                listener.clickedArticleCategories(articleTitleList[position].category)
            }
        }
    }

    interface OnArticleCategoryClick {
        fun clickedArticleCategories(category: Category)
    }

}