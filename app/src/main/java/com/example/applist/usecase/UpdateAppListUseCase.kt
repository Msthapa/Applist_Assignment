package com.example.applist.usecase


import com.example.applist.repository.Repository
import javax.inject.Inject

class UpdateAppListUseCase @Inject constructor(private val repository: Repository) {

    suspend operator fun invoke(forceUpdate : Boolean = false) {
        repository.updateAppList(forceUpdate)
    }
}