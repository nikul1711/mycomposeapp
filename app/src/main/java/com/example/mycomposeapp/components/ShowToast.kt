package com.example.mycomposeapp.components

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext

@Composable
fun ShowToast(message: String) {
    val context = LocalContext.current

    LaunchedEffect(Unit) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}