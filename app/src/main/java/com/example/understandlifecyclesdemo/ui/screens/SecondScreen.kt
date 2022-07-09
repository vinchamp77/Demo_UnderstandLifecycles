package com.example.understandlifecyclesdemo.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.understandlifecyclesdemo.ui.MainViewModel
import com.example.understandlifecyclesdemo.ui.MainViewModelFactory
import com.example.understandlifecyclesdemo.ui.common.DefaultButton

@Composable
fun SecondScreen(
    popBackStack: () -> Unit,
) {
    //compose navigation creates a new view model store owner for each destination
    val viewModel: MainViewModel = viewModel(
        factory = MainViewModelFactory("SecondScreen"))

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