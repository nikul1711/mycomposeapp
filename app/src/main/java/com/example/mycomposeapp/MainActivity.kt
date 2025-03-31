package com.example.mycomposeapp

import android.content.ClipData
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mycomposeapp.ui.theme.MyComposeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyComposeAppTheme {
//                MainScrenn()
//                ModifierDemo()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyComposeAppTheme {
        MainScreenForNavigation()
    }
}

@Composable
fun MainScreenForNavigation() {
    val list = List(20) { "Hello Android $it" }
    LazyColumn {
        item {
            Text(
                text = "Hello World", modifier = Modifier
                    .padding(16.dp)
                    .fillMaxSize()
            )
        }
    }
}

@Composable
fun SecondScreenForNavigation() {

}


@Composable
fun MainScreenBox() {
    val context = LocalContext.current

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = 12.dp)
    ) {
        Button(onClick = {
            Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show()
        }, modifier = Modifier.align(Alignment.CenterStart)) { Text("Click CenterStart") }

        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = null, modifier = Modifier.align(Alignment.Center)
        )
        Button(onClick = {
            Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show()
        }, modifier = Modifier.align(Alignment.CenterEnd)) { Text("Click CenterEnd") }

        Button(onClick = {
            Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show()
        }, modifier = Modifier.align(Alignment.TopCenter)) { Text("Click TopCenter") }
        Button(onClick = {
            Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show()
        }, modifier = Modifier.align(Alignment.BottomCenter)) { Text("Click BottomCenter") }
    }


}

@Composable
fun ModifierDemo() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        val boxModifier = Modifier
            .weight(1f)
            .padding(10.dp)
            .clip(RoundedCornerShape(20.dp))
            .size(200.dp, 200.dp)
        Row() {
            for (int in 1..4) {
                Box(
                    modifier = boxModifier
                        .background(Color.Red)
                ) { }
            }
        }
        Row() {
            for (int in 1..4) {
                Box(
                    modifier = boxModifier
                        .background(Color.Yellow)
                ) { }
            }
        }
        Row() {
            for (int in 1..4) {
                Box(
                    modifier = boxModifier
                        .background(Color.Green)
                ) { }
            }
        }
        Row() {
            for (int in 1..4) {
                Box(
                    modifier = boxModifier
                        .background(Color.Blue)
                ) { }
            }
        }
        Row() {
            for (int in 1..4) {
                Box(
                    modifier = boxModifier
                        .background(Color.Black)
                ) { }
            }
        }
    }

}