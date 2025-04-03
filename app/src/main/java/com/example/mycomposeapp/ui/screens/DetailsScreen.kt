package com.example.mycomposeapp.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun DetailsScreen(navController: NavController, data: String? = null) {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.align(Alignment.Center)) {
            Text(
                text = "Details Screen : $data", modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Button(
                onClick = { navController.popBackStack() }, modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Text("Back to Home")
            }
        }

    }
}