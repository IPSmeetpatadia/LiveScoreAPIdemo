package com.example.livescoreapidemo.dataclasses.newsdetails

data class SegmentTracking(
    val metaData: MetaData,
    val newsParams: NewsParams,
    val screenClass: String,
    val screenName: String
)