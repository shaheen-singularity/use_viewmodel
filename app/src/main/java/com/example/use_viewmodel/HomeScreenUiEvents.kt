package com.example.use_viewmodel

sealed class HomeScreenUiEvents{
    data class NameTextField(val nameValue:String): HomeScreenUiEvents()

}
