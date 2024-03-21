package com.example.use_viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class HomeScreenViewModel: ViewModel() {
    var uiState = mutableStateOf(HomeScreenDataClass())
    fun onEvent(events: HomeScreenUiEvents){
        when(events){
            is HomeScreenUiEvents.NameTextField ->{
                uiState.value = uiState.value.copy(
                    name = events.nameValue
                )
            }
        }
    }
}