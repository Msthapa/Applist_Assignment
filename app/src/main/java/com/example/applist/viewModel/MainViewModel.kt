package com.example.applist.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.applist.usecase.UpdateAppListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val updateAppsListUseCase: UpdateAppListUseCase
): ViewModel() {

     fun updateAppList() {
         viewModelScope.launch {
             updateAppsListUseCase.invoke()
         }
     }

}