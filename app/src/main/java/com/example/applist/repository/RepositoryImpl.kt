package com.example.applist.repository

import com.bumptech.glide.RequestManager
import com.example.applist.model.dao.ManageAppDao
import com.example.applist.model.data.AppDetailItem
import com.example.applist.model.entity.toAppDetailItem
import com.example.applist.model.entity.toEntity
import com.example.applist.model.retrofitContract.AppsApiService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val api: AppsApiService,
    private val dao: ManageAppDao
) : Repository {

    private val _apps = MutableStateFlow<List<AppDetailItem>>(emptyList())
    val apps: StateFlow<List<AppDetailItem>> = _apps.asStateFlow()

    override suspend fun updateAppList(forceRefresh: Boolean )  {
        val cachedAppList = dao.getAppList().first()
        if(cachedAppList.isNotEmpty() && !forceRefresh){
            _apps.value = cachedAppList.map { it.toAppDetailItem() }
            return
        }
        val result = api.getAppsList()
        val newList = result.feed.results

        dao.clearAllApps() // Clear old data if available
        dao.insertApps(newList.map { it.toEntity() })
        _apps.value = newList

    }

    override fun getAppList() = apps
}