package com.example.mycomposeapp.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun AnimationScreen(navController: NavController, data: String? = null) {
    val state = remember { mutableStateOf(true) }
    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.align(Alignment.Center)) {

            AnimatedVisibility(state.value)
            {
                Text(
                    "data: $data",
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            }
            Button(
                onClick = { state.value = !state.value },
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Text("Toggle Visible")
            }
        }
    }
}