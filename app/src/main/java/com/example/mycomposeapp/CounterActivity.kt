package com.example.mycomposeapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mycomposeapp.theme.MyComposeAppTheme

class CounterActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyComposeAppTheme {
                CounterScreenPreview()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CounterScreenPreview() {
    MyComposeAppTheme {
        CounterScreen()
    }
}

@Composable
fun CounterScreen() {
    var resetState by remember { mutableStateOf(0) }
    Log.d("CounterScreen", "state updated")
    if (resetState < 5) {
        var count by remember { mutableStateOf(0) }
        Log.d("CounterScreen", "count state executed: $count")
        Column(
            modifier = Modifier.fillMaxSize(),
            Arrangement.Center,
            Alignment.CenterHorizontally
        ) {
            Text("Current count is: $count")
            Button(onClick = {
                count++
                resetState++
            }, modifier = Modifier.padding(10.dp)) {
                Text("Click me")
            }
        }
    } else {
        Log.d("CounterScreen", "state reset ")

        Column(
            modifier = Modifier.fillMaxSize(),
            Arrangement.Center,
            Alignment.CenterHorizontally
        ) {
            Button(onClick = { resetState = 0 }, modifier = Modifier.padding(10.dp)) {
                Text("Reset")
            }
        }
    }

}