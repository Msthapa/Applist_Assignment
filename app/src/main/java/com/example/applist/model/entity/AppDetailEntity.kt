package com.example.applist.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.applist.model.data.AppDetailItem

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

fun AppDetailEntity.toAppDetailItem(): AppDetailItem = AppDetailItem(
    id = id,
    artistName = artistName,
    name = name,
    releaseDate = releaseDate,
    kind = kind,
    artworkUrl100 = artworkUrl100,
    url = url
)

fun AppDetailItem.toEntity(): AppDetailEntity = AppDetailEntity(
    id = id,
    artistName = artistName,
    name = name,
    releaseDate = releaseDate,
    kind = kind,
    artworkUrl100 = artworkUrl100,
    url = url
)