package com.example.mycomposeapp

import android.os.Bundle
import android.widget.Toast

import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.Alignment
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContent {
            MyComposeAppTheme {
                val navController = rememberNavController() // Create NavController

                NavHost(navController = navController, startDestination = "home") {
                    composable("home") { HomeScreen(navController) }
                    composable("second") { SecondScreen(navController) }
                }
            }
        }
    }
}

@Composable
fun HomeScreen(navController: NavController) {
    Box(modifier = Modifier.fillMaxSize()) {
        Button(modifier = Modifier.align(Alignment.Center), onClick = {
            navController.navigate("second")
        }) {
            Text("Go to Second Screen")
        }
    }

}

@Composable
fun SecondScreen(navController: NavController) {
    Button(onClick = { navController.navigate("second") }) {
        Text(" Second Screen")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyComposeAppTheme {
        HomeScreen(rememberNavController())
    }

}

@Composable
fun MainScreenForNavigation(navController: NavHostController) {
    val listSize = 5
    val listColumns = List(listSize) { "Hello Android $it" }
    val listRow = List(listSize) { "Hello Nick $it" }

    LazyColumn {
        item {
            LazyItemHeader("Hello Android Developer")
        }
        items(listColumns) { item ->
            LazyListItemData(item, onClick = {
                // Call navigate on the NavController when item is clicked
                navController.navigate("second")
            })
        }
        item {
            LazyItemHeader("User Developer")
        }
        items(listRow) { item ->
            LazyListItemData(item, onClick = {
                navController.navigate("second")
            })
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
fun LazyListItemData(item: String, onClick: (data: String) -> Unit) {
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
        Text(
            text = item,
            modifier = Modifier
                .align(Alignment.CenterStart)
                .clickable { onClick(item) },
        )
    }
}

@Composable
fun SecondScreenForNavigation(navController: NavHostController) {
    Column {
        Text(
            text = "Second Screen",
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp
        )
    }
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