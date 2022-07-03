package com.example.understandlifecyclesdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.understandlifecyclesdemo.ui.navigation.BuildNavGraph
import com.example.understandlifecyclesdemo.ui.theme.SimpleNavComposeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
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
