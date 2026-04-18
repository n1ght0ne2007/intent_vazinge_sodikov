package com.example.intent_vazinge


import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.intent_vazinge.ui.theme.Intent_vazingeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Intent_vazingeTheme {
                Greeting()
            }
        }
    }
}

@Composable
fun Greeting() {
    val context = LocalContext.current
    Column (modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally){
        Button(onClick = {callPhoneNumber(context)}) {
            Text("Позвонить")
        }
        Button(onClick = {sendEmail(context, address = "contact@example.com", subject = "Обращение")}) {
            Text("Написать email")
        }
        Button(onClick = {showOnMap(context, latitube = 60.0237, longitude = 30.2289, label = "Наш офис")}) {
            Text("Показать офис на карте")
        }
        Button(onClick = {sharePhone(context, text = "Контакт: +7(495) 123-45-67, contact@example.com")}) {
            Text("Поделиться контактом")
        }
    }
}

fun callPhoneNumber(context: Context){

    val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:+74951234567"))
    if (intent.resolveActivity(context.packageManager) != null) {
        context.startActivity(intent)}
}

fun sendEmail(context: Context,address: String, subject: String){
    val intent = Intent(Intent.ACTION_SENDTO).apply {
        data = Uri.parse("mailto: ")
        putExtra(Intent.EXTRA_EMAIL, arrayOf(address))
        putExtra(Intent.EXTRA_SUBJECT, subject)
    }
    if (intent.resolveActivity(context.packageManager) != null){
        context.startActivity(intent)
    }
}

fun showOnMap(context : Context, latitube: Double, longitude: Double, label: String){
    val geoUri = Uri.parse("geo:0,07?q=$latitube,$longitude($label)")
    val intent = Intent(Intent.ACTION_VIEW, geoUri)
    if (intent.resolveActivity(context.packageManager) != null){
        context.startActivity(intent)
    }
}

fun sharePhone(context: Context, text: String){
    val sendIntent = Intent(Intent.ACTION_SEND).apply {
        type = "text/plain"
        putExtra(Intent.EXTRA_TEXT, text)
    }
    val chooser = Intent.createChooser(sendIntent, "Поделиться через ...")
    context.startActivity(chooser)
}

@Preview(showBackground = true)
@Composable
fun BirthdayCardPreview() {
    Greeting()
}