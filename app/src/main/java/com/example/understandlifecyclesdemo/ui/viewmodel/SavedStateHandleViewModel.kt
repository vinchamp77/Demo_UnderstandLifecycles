package com.example.understandlifecyclesdemo.ui.viewmodel

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.understandlifecyclesdemo.ui.KEY
import com.example.understandlifecyclesdemo.ui.tag

class SavedStateHandleViewModel(
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    init {
        Log.d(tag, "SavedStateHandleViewModel: onCreated()")

        restoreSavedStateHandle(savedStateHandle)

        savedStateHandle.set(KEY, "View Model")
    }

    override fun onCleared() {
        super.onCleared()

        Log.d(tag, "SavedStateHandleViewModel: onCleared()")
    }

    private fun restoreSavedStateHandle(savedStateHandle: SavedStateHandle) {
        val value: String? = savedStateHandle.get(KEY)
        if (value != null) {
            Log.d(tag, "SavedStateHandleViewModel -  Restore key:$KEY value:$value")
        } else {
            Log.d(tag, "SavedStateHandleViewModel - Nothing to restore")
        }
    }
}