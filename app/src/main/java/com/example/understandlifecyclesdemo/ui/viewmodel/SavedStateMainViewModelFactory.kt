package com.example.understandlifecyclesdemo.ui.viewmodel

import android.os.Bundle
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistryOwner

@Suppress("UNCHECKED_CAST")
class SavedStateMainViewModelFactory(
    owner: SavedStateRegistryOwner,
    bundle: Bundle? = null,
    private val name: String
) : AbstractSavedStateViewModelFactory(owner, bundle) {

    override fun <T : ViewModel> create(
        key: String,
        modelClass: Class<T>,
        handle: SavedStateHandle
    ): T {
        if (modelClass.isAssignableFrom(SavedStateMainViewModel::class.java)) {
            return SavedStateMainViewModel(handle, name) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class")
    }
}