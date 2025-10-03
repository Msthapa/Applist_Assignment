package com.example.applist.viewModel

import androidx.lifecycle.ViewModel
import com.example.applist.model.data.AppDetailItem
import com.example.applist.usecase.GetAppsListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class ApplistFragmentViewModel @Inject constructor(
    private val getAppsListUseCase: GetAppsListUseCase
): ViewModel() {

    val apps: StateFlow<List<AppDetailItem>> = getAppsListUseCase.invoke()

}