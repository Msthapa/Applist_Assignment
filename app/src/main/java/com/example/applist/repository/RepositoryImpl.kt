package com.example.applist.repository

import com.bumptech.glide.RequestManager
import com.example.applist.model.dao.ManageAppDao
import com.example.applist.model.data.AppDetailItem
import com.example.applist.model.retrofitContract.AppsApiService
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val api: AppsApiService,
    private val dao: ManageAppDao,
    private val glide: RequestManager
) : Repository {

    override suspend fun getAppsList() : List<AppDetailItem> {
        TODO("Not yet implemented")
    }
}