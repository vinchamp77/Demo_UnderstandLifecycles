package com.example.understandlifecyclesdemo.ui.screens

import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.understandlifecyclesdemo.ui.MainActivity
import com.example.understandlifecyclesdemo.ui.SecondActivity
import com.example.understandlifecyclesdemo.ui.common.DefaultButton
import com.example.understandlifecyclesdemo.ui.theme.SimpleNavComposeAppTheme

@Composable
fun LoginScreen(
    navigateToHome: () -> Unit
) {
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
            text = "Focus Demo",
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
            LoginScreen(
                navigateToHome = {}
            )
        }
    }
}
