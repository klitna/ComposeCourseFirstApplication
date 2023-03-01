package com.example.composecourseapplication

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    val textFieldState = MutableLiveData("")

    fun onTextChange(newText: String){
        textFieldState.value = newText
    }
}