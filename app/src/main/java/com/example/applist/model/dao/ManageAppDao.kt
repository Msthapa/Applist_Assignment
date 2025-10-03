package com.example.applist.model.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.applist.model.entity.AppDetailEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ManageAppDao {
    @Query("DELETE FROM app_detail")
    suspend fun clearAllApps()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertApps(apps: List<AppDetailEntity>)

    @Query("SELECT * FROM app_detail")
    fun getAppList(): Flow<List<AppDetailEntity>>
}