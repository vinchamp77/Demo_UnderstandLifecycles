package com.example.understandlifecyclesdemo.ui.screens

import android.content.Intent
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.understandlifecyclesdemo.ui.MainViewModel
import com.example.understandlifecyclesdemo.ui.MainViewModelFactory
import com.example.understandlifecyclesdemo.ui.SecondActivity
import com.example.understandlifecyclesdemo.ui.common.DefaultButton
import com.example.understandlifecyclesdemo.ui.theme.SimpleNavComposeAppTheme

@Composable
fun SecondScreen(
    navigateToHome: () -> Unit
) {
    //compose navigation creates a new view model store owner for each destination
    val viewModel: MainViewModel = viewModel(factory = MainViewModelFactory("FirstScreen"))

    val context = LocalContext.current

    Column (
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text("First Screen", fontSize = 40.sp)

        DefaultButton(
            text = "Next Screen",
            onClick = navigateToHome
        )

        DefaultButton(
            text = "Loses Focus",
            onClick = {
                context.startActivity(Intent(context, SecondActivity::class.java))
            }
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
            SecondScreen(
                navigateToHome = {}
            )
        }
    }
}
