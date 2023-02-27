package com.example.livescoreapidemo.dataclasses.news

data class NewsList(
    val adsTargeting: AdsTargeting,
    val categories: List<Category>,
    val featuredArticles: List<FeaturedArticle>,
    val homepageArticles: List<HomepageArticle>,
    val isNetworkError: Boolean,
    val layoutContext: LayoutContext,
    val segmentTracking: SegmentTracking,
    val topStories: List<TopStory>
)