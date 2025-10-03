package com.example.applist.model.data

data class AppListResponse (
    val feed: Feed
)

data class Feed(
    val results: List<AppDetailItem>
)

data class AppDetailItem(
    val artistName: String,
    val id: String,
    val name: String,
    val releaseDate: String,
    val kind: String,
    val artworkUrl100: String,
    val url: String
)