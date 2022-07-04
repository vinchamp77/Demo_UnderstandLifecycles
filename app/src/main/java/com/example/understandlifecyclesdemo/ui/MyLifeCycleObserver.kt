package com.example.understandlifecyclesdemo.ui

import android.util.Log
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner

class MyLifeCycleObserver(private val name: String) : DefaultLifecycleObserver {

    private val tag = "LifeCycleDebug"

    override fun onCreate(owner: LifecycleOwner) {
        Log.d("$tag:$name", "onCreated()")
    }

    override fun onStart(owner: LifecycleOwner) {
        Log.d("$tag:$name", "onStart()")
    }

    override fun onResume(owner: LifecycleOwner) {
        Log.d("$tag:$name", "onResume()")
    }

    override fun onPause(owner: LifecycleOwner) {
        Log.d("$tag:$name", "onPause()")
    }

    override fun onStop(owner: LifecycleOwner) {
        Log.d("$tag:$name", "onStop()")
    }

    override fun onDestroy(owner: LifecycleOwner) {
        Log.d("$tag:$name", "onDestroy()")
    }
}