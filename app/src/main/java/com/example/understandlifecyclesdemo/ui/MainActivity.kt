package com.example.understandlifecyclesdemo.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.understandlifecyclesdemo.ui.navigation.NavGraph
import com.example.understandlifecyclesdemo.ui.theme.UnderstandLifeCyclesDemoAppTheme
import com.example.understandlifecyclesdemo.ui.viewmodel.MainViewModel
import com.example.understandlifecyclesdemo.ui.viewmodel.MainViewModelFactory
import com.example.understandlifecyclesdemo.ui.viewmodel.SavedStateHandleViewModel

const val KEY = "key"

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(tag,"***** onCreate *****")

        val observer = MyLifeCycleObserver(MainActivity::class.simpleName!!)
        lifecycle.addObserver(observer)

        setContent {
            MainScreen()
        }

        if(savedInstanceState == null) {
            Log.d(tag, "savedInstanceState is null")
        } else {
            restoreSavedInstanceState(savedInstanceState)
        }

    }

    override fun onRestart() {
        super.onRestart()

        Log.d(
            tag,
            "${MainActivity::class.simpleName!!}: onRestart()")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        Log.d(tag, "***** onSaveInstanceState *****")

        val value = "Main Activity"
        outState.putString(KEY, value)
        Log.d(tag, "Saving key:$KEY value:$value")
        super.onSaveInstanceState(outState) // <-- needs to be called last
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        Log.d(tag,"***** onRestoreInstanceState *****")
        restoreSavedInstanceState(savedInstanceState)
    }

    private fun restoreSavedInstanceState(savedInstanceState: Bundle) {
        val value = savedInstanceState.getString(KEY)
        value?.run {
            Log.d(tag, "Restore key:$KEY value:$value")
        }
    }
}

@Composable
private fun MainScreen() {

    //view model store owner belongs to the activity
    val viewModel: MainViewModel = viewModel(factory = MainViewModelFactory("MainScreen"))
    val savedStateHandleViewModel: SavedStateHandleViewModel = viewModel()


    UnderstandLifeCyclesDemoAppTheme {
        val navController = rememberNavController()
        NavGraph(navController)
    }
}
