package com.example.intent_vazinge

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.intent_vazinge.ui.theme.Intent_vazingeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Intent_vazingeTheme {
                Scaffold( modifier = Modifier.fillMaxSize() ) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {

    Column {
        Button(onClick = {callPhoneNumber()}) {
            Text("Позвонить")
        }
        Button(onClick = {}) {
            Text("Написать email")
        }
        Button(onClick = {}) {
            Text("Показать офис на карте")
        }
        Button(onClick = {}) {
            Text("Поделиться контактом")
        }
    }
}
fun callPhoneNumber(){
    val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:+7912347"))
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Intent_vazingeTheme {
        Greeting("Android")
    }
}