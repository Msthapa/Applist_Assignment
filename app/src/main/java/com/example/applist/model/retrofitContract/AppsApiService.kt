package com.example.applist.model.retrofitContract

import com.example.applist.model.data.AppListResponse
import retrofit2.http.GET

interface AppsApiService {

    @GET("/api/v2/us/apps/top-free/100/apps.json")
    suspend fun getAppsList() : AppListResponse
}