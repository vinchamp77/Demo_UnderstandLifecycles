package com.example.understandlifecyclesdemo.ui

import android.util.Log
import androidx.lifecycle.ViewModel

class MainViewModel(private val name: String) : ViewModel() {

    init {
        Log.d(tag, "${name}ViewModel: onCreated()")
    }

    override fun onCleared() {
        super.onCleared()

        Log.d(tag, "${name}ViewModel: onCleared()")
    }
}