package com.example.mycomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mycomposeapp.ui.theme.MyComposeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyComposeAppTheme {
                MyApp()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyComposeAppTheme {
        MyApp()
    }

}

@Composable
fun MyApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "main") {
        composable("main") {
            MainScreen(navController)
        }
        composable("details") {
            DetailsScreen(navController)
        }
    }
}

@Composable
fun MainScreen(navController: NavController) {
    val listSize = 5
    val listColumns = List(listSize) { "Hello Android $it" }

    LazyColumn {
        item {
            LazyItemHeader("Hello Android Developer")
        }
        items(listColumns) { item ->
            LazyListItemData(item, onClick = {
                // Call navigate on the NavController when item is clicked
                navController.navigate("details")
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
            .clickable { onClick(item) }
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
        )
    }
}

@Composable
fun DetailsScreen(navController: NavController) {
    Box(modifier = Modifier.fillMaxSize()) {
        Button(
            onClick = { navController.popBackStack() },
            modifier = Modifier.align(Alignment.Center)
        ) {
            Text("Back to Home")
        }
    }
}