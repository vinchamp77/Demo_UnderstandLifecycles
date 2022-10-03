package com.example.understandlifecyclesdemo.ui.viewmodel

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.understandlifecyclesdemo.ui.KEY
import com.example.understandlifecyclesdemo.ui.tag

class SavedStateMainViewModel(
    savedStateHandle: SavedStateHandle,
    name: String,
) : ViewModel() {

    init {
        Log.d(tag, "SavedStateMainViewModel: onCreated()")

        restoreSavedStateHandle(savedStateHandle)

        savedStateHandle.set(KEY, "SavedStateMainViewModel")
    }

    private fun restoreSavedStateHandle(savedStateHandle: SavedStateHandle) {
        val value: String? = savedStateHandle.get(KEY)
        if (value != null) {
            Log.d(tag, "SavedStateMainViewModel -  Restore key:$KEY value:$value")
        } else {
            Log.d(tag, "SavedStateMainViewModel - Nothing to restore")
        }
    }
}