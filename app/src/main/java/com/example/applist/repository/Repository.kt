package com.example.applist.repository

import com.example.applist.model.data.AppDetailItem

interface Repository {

    suspend fun getAppsList() : List<AppDetailItem>

}