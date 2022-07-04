package com.example.understandlifecyclesdemo.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.understandlifecyclesdemo.ui.MyLifeCycleObserver
import com.example.understandlifecyclesdemo.ui.navigation.BuildNavGraph
import com.example.understandlifecyclesdemo.ui.theme.SimpleNavComposeAppTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        val observer = MyLifeCycleObserver(MainActivity::class.simpleName!!)
        lifecycle.addObserver(observer)
        lifecycle.addObserver(observer)

        setContent {
            val viewModel:MainViewModel = viewModel()
            MainScreen()
        }
    }
}

@Composable
private fun MainScreen() {
    SimpleNavComposeAppTheme {
        val navController = rememberNavController()
        BuildNavGraph(navController)
    }
}
