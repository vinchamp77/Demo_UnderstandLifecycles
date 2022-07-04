package com.example.understandlifecyclesdemo.ui

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.ViewModel

@SuppressLint("LongLogTag")
class MainViewModel : ViewModel() {

    private val tag = "LifeCycleDebug:ViewModel"

    init {
        Log.d(tag, "onCreated()")
    }

    override fun onCleared() {
        super.onCleared()

        Log.d(tag, "onCleared()")
    }
}