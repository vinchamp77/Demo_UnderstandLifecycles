package com.example.understandlifecyclesdemo.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.understandlifecyclesdemo.ui.tag

class MainViewModel(
    private val name: String
) : ViewModel() {

    init {
        Log.d(tag, "${name}ViewModel: onCreated()")
    }

    override fun onCleared() {
        super.onCleared()

        Log.d(tag, "${name}ViewModel: onCleared()")
    }
}