package com.example.applist.repository

import com.example.applist.model.data.AppDetailItem
import kotlinx.coroutines.flow.StateFlow

interface Repository {

    suspend fun updateAppList()

    fun getAppList() : StateFlow<List<AppDetailItem>>

}