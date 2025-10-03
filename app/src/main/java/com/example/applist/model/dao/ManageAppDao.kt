package com.example.applist.model.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.applist.model.entity.AppDetailEntity

@Dao
interface ManageAppDao {
    @Query("SELECT * FROM app_detail")
    suspend fun getAllApps(): List<AppDetailEntity>
}