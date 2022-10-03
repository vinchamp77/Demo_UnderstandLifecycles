package com.example.understandlifecyclesdemo.ui.viewmodel

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.understandlifecyclesdemo.ui.KEY
import com.example.understandlifecyclesdemo.ui.tag

class NoArgsSavedStateViewModel(
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    init {
        Log.d(tag, "NoArgsSavedStateViewModel: onCreated()")

        restoreSavedStateHandle(savedStateHandle)

        savedStateHandle.set(KEY, "NoArgsSavedStateViewModel")
    }

    private fun restoreSavedStateHandle(savedStateHandle: SavedStateHandle) {
        val value: String? = savedStateHandle.get(KEY)
        if (value != null) {
            Log.d(tag, "NoArgsSavedStateViewModel -  Restore key:$KEY value:$value")
        } else {
            Log.d(tag, "NoArgsSavedStateViewModel - Nothing to restore")
        }
    }
}