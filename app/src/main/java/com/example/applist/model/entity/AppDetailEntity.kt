package com.example.applist.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName ="app_detail")
data class AppDetailEntity (
    @PrimaryKey val id : String,
    val artistName: String,
    val name: String,
    val releaseDate: String,
    val kind: String,
    val artworkUrl100: String,
    val url: String
)