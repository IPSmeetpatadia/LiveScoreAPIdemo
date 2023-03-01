package com.example.livescoreapidemo.dataclasses.newsdetails

data class NewsDetails(
    val activeSport: String,
    val adsTargeting: AdsTargeting,
    val ampWidgetsData: Any,
    val article: Article,
    val articleId: String,
    val categories: List<CategoryX>,
    val categoryName: String,
    val categoryTitle: String,
    val generated: String,
    val isAmpEnabled: Any,
    val isArticle: Boolean,
    val layoutContext: LayoutContext,
    val segmentTracking: SegmentTracking
)