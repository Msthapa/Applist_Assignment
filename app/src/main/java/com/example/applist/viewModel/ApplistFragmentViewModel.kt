package com.example.applist.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.applist.model.data.AppDetailItem
import com.example.applist.usecase.GetAppsListUseCase
import com.example.applist.usecase.UpdateAppListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ApplistFragmentViewModel @Inject constructor(
    private val getAppsListUseCase: GetAppsListUseCase,
    private val forceRefreshAppsUseCase: UpdateAppListUseCase
): ViewModel() {

    val apps: StateFlow<List<AppDetailItem>> = getAppsListUseCase.invoke()

     fun refreshDataOnSwipe(onItemRefreshed: () -> Unit){
         viewModelScope.launch {
             forceRefreshAppsUseCase.invoke(true)
             onItemRefreshed()
         }
    }

}