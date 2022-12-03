package com.saisai.noteapp

import android.os.Bundle
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Divider
import androidx.compose.material.TextButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.saisai.noteapp.ui.theme.NoteAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NoteAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting() {
    Column(modifier = Modifier
        .padding(top = 192.dp)
        .padding(start = 48.dp)
    ) {
        /*Text(
            text = "Hi there!",
            style = MaterialTheme.typography.headlineLarge.copy(
                fontWeight = FontWeight.ExtraLight
            )
        )
        Text(
            text = "This is",
            style = MaterialTheme.typography.headlineLarge.copy(
                fontWeight = FontWeight.ExtraLight
            )
        )*/

        Image(
            painter = painterResource(id = R.drawable.ic_note),
            contentDescription = "Note icon",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .padding(top = 12.dp)
                .size(width = 150.dp, height = 35.dp)
        )

        Text(
            text = "Login",
            style = MaterialTheme.typography.titleLarge.copy(
                fontWeight = FontWeight.Light
            ),
            modifier = Modifier.padding(top = 96.dp)
        )

        var text by remember { mutableStateOf("") }
        BasicTextField(
            modifier = Modifier
                .padding(top = 12.dp)
                .fillMaxWidth(),
            value = text, onValueChange = { text = it },
            textStyle = TextStyle(
                color = Color.White,
                fontStyle = FontStyle(12)
            )
        )
        Divider(
            modifier = Modifier
                .padding(end = 48.dp, top = 4.dp),
            color = Color.White
        )
        Text(
            text = "E-mail",
            style = MaterialTheme.typography.bodySmall.copy(
                fontWeight = FontWeight.Light
            ),
            modifier = Modifier.padding(top = 8.dp, start = 2.dp)
        )

        BasicTextField(
            modifier = Modifier
                .padding(top = 12.dp)
                .fillMaxWidth(),
            value = text, onValueChange = { text = it },
            textStyle = TextStyle(color = Color.White)
        )
        Divider(
            modifier = Modifier
                .padding(end = 48.dp, top = 4.dp),
            color = Color.White
        )
        Row(modifier = Modifier.padding(top = 8.dp, end = 50.dp)) {
            Text(
                text = "Password",
                style = MaterialTheme.typography.bodySmall.copy(
                    fontWeight = FontWeight.Light
                ),
                modifier = Modifier
                    .padding(start = 2.dp)
                    .weight(1f)
            )
            Text(
                text = "Not an user?  |  ",
                style = MaterialTheme.typography.bodySmall.copy(
                    fontWeight = FontWeight.Light
                ),
                modifier = Modifier.padding(start = 2.dp)
            )

            Text(
                modifier = Modifier.clickable(
                    enabled = true,
                    onClickLabel = null,
                    role = null,
                    onClick = {
                        /* Navigate to register screen */
                        println("hello")
                    }
                ),
                text = "Register",
                style = MaterialTheme.typography.bodySmall.copy(
                    fontWeight = FontWeight.Light
                )
            )

           /* ClickableText(
                text = AnnotatedString("Register"),
                onClick = {
                    *//* Navigate to register screen *//*
                    println("hello")
                }
            )*/
        }


    }


}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NoteAppTheme {
        Greeting()
    }
}