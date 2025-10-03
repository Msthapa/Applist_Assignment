package com.example.applist.model

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.applist.model.dao.ManageAppDao
import com.example.applist.model.entity.AppDetailEntity

@Database(entities = [AppDetailEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
  abstract fun appDao() : ManageAppDao
}