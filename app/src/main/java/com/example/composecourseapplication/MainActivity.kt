package com.example.composecourseapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

@Composable
fun MainScreen(viewModel: MainViewModel = MainViewModel()){
    val newNameStateContent = viewModel.textFieldState.observeAsState("")
    Surface(color = Color.LightGray, modifier = Modifier.fillMaxSize()){
        Column(modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            GreetingList(
                newNameStateContent.value
            ) { newName -> viewModel.onTextChange(newName) }
        }
    }
}

@Composable
fun GreetingList(name: String, textFieldUpdate: (newName: String) -> Unit){
    Column{
        TextField(value = name, onValueChange = textFieldUpdate)
        Button(onClick = { }) {
            Text(name)
        }
    }
}

@Composable
fun Greeting(name: String){
    Text(text = "Hello $name!", style = MaterialTheme.typography.h5)
}

@Composable
fun HorizontalBar(color: Color){
    Surface(
        color = color,
        modifier = Modifier
            .height(70.dp)
            .fillMaxSize()
    ) {
        Text(text = "Wrapped Content", modifier = Modifier.wrapContentSize(), style = MaterialTheme.typography.h3)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreviewMainActivity(){
    MainScreen()
}


