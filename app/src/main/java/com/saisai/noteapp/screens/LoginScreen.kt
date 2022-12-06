package com.saisai.noteapp.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Divider
import androidx.compose.material.OutlinedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.saisai.noteapp.R
import com.saisai.noteapp.Screen

@Composable
fun LoginScreen(
    navController: NavController
) {
    Column(modifier = Modifier
        .padding(top = 192.dp, start = 48.dp, end = 48.dp)
    ) {
        NoteIcon()
        LoginForm(navController)
        LoginButton()
    }
}

@Composable
fun NoteIcon() {
    Image(
        painter = painterResource(id = R.drawable.ic_note),
        contentDescription = null,
        contentScale = ContentScale.Fit,
        modifier = Modifier
            .size(width = 150.dp, height = 35.dp)
    )
}

@Composable
fun LoginForm(
    navController: NavController
) {
    Text(
        text = "Login",
        style = MaterialTheme.typography.titleLarge.copy(
            fontWeight = FontWeight.Light
        ),
        modifier = Modifier.padding(top = 96.dp)
    )

    var text by rememberSaveable { mutableStateOf("") }
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
            .padding(top = 4.dp),
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
            .padding(top = 4.dp),
        color = Color.White
    )
    Row(modifier = Modifier.padding(top = 8.dp)) {
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
                    navController.navigate(route = Screen.Register.route)
                }
            ),
            text = "Register",
            style = MaterialTheme.typography.bodySmall.copy(
                fontWeight = FontWeight.Light
            )
        )

    }
}

@Composable
fun LoginButton() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(top = 96.dp)
            .fillMaxWidth()
    ) {
        OutlinedButton(
            modifier = Modifier
                .width(230.dp)
                .height(50.dp),
            border = BorderStroke(1.dp, Color.White),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = MaterialTheme.colorScheme.background
            ),
            onClick = {
                println("hello world")
            }
        ) {
            Text("Login")
        }
    }

}

