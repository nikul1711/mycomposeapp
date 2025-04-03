package com.example.mycomposeapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mycomposeapp.ui.theme.MyComposeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyComposeAppTheme {
                MainScreenForNavigation()
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
    val listSize = 5;
    val listColumns = List(listSize) { "Hello Android $it" }
    val listRow = List(listSize) { "Hello Nick $it" }
    val list3 = List(listSize) { "Android v.$it" }
    Column {
        LazyItemHeader("Android Developer")
        LazyRow(modifier = Modifier.height(110.dp)) {
            items(list3) { item ->
                LazyListItemData(item)
            }
        }
        LazyColumn() {
            item {
                LazyItemHeader("Hello Android Developer")
            }
            items(listColumns) { item ->
                LazyListItemData(item)
            }
            item {
                LazyItemHeader("User Developer")
            }
            items(listRow) { item ->
                LazyListItemData(item)
            }
        }
    }
}

@Composable
fun LazyItemHeader(header: String) {
    Text(
        text = header,
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth(),
        textAlign = TextAlign.Center,
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp
    )
}

@Composable
fun LazyListItemData(item: String) {
    Box(
        modifier = Modifier
            .padding(4.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color.Cyan)
            .height(80.dp)
            .padding(12.dp)
            .fillMaxWidth()
    ) {
        Image(
            painter = painterResource(R.drawable.ic_close_24),
            contentDescription = null,
            modifier = Modifier
                .height(16.dp)
                .width(16.dp)
                .align(Alignment.TopEnd)
        )
        Text(text = item, modifier = Modifier.align(Alignment.CenterStart))
    }
}

@Composable
fun SecondScreenForNavigation() {
}

@Composable
fun ThirdScreenForNavigation() {
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