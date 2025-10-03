package com.example.applist.repository

import com.bumptech.glide.RequestManager
import com.example.applist.model.dao.ManageAppDao
import com.example.applist.model.data.AppDetailItem
import com.example.applist.model.retrofitContract.AppsApiService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val api: AppsApiService,
    private val dao: ManageAppDao,
    private val glide: RequestManager
) : Repository {

    private val _apps = MutableStateFlow<List<AppDetailItem>>(emptyList())
    val apps: StateFlow<List<AppDetailItem>> = _apps.asStateFlow()

    override suspend fun updateAppList()  {
        val result = api.getAppsList()
        _apps.value = result.feed.results
    }

    override fun getAppList() = apps
}