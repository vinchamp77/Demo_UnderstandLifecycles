package com.example.understandlifecyclesdemo.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.understandlifecyclesdemo.ui.MainViewModel
import com.example.understandlifecyclesdemo.ui.MainViewModelFactory
import com.example.understandlifecyclesdemo.ui.common.DefaultButton
import com.example.understandlifecyclesdemo.ui.theme.SimpleNavComposeAppTheme

@Composable
fun HomeScreen(
    popBackStack: () -> Unit,
) {
    //compose navigation creates a new view model store owner for each destination
    val viewModel: MainViewModel = viewModel(factory = MainViewModelFactory("HomeScreen"))

    Column (
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Second Screen", fontSize = 40.sp)

        DefaultButton(
            text = "Back",
            onClick = popBackStack
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    SimpleNavComposeAppTheme(useSystemUiController = false) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            HomeScreen(popBackStack = {})
       }
    }
}