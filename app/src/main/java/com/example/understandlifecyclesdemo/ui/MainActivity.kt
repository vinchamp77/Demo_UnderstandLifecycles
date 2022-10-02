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

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        val observer = MyLifeCycleObserver(MainActivity::class.simpleName!!)
        lifecycle.addObserver(observer)

        setContent {
            MainScreen()
        }
    }

    override fun onRestart() {
        super.onRestart()

        Log.d(
            tag,
            "${MainActivity::class.simpleName!!}: onRestart()")
    }
}

@Composable
private fun MainScreen() {

    //view model store owner belongs to the activity
    val viewModel: MainViewModel = viewModel(factory = MainViewModelFactory("MainScreen"))

    UnderstandLifeCyclesDemoAppTheme {
        val navController = rememberNavController()
        NavGraph(navController)
    }
}
