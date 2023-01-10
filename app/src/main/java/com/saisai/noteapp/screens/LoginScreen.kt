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
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
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
import com.saisai.noteapp.navigation.Screen
import com.saisai.noteapp.viewmodel.ApiViewModel
import androidx.compose.ui.tooling.*
import kotlinx.coroutines.delay
import java.util.Timer

@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: ApiViewModel
) {
    var textEmail by rememberSaveable { mutableStateOf("") }
    var textPassword by rememberSaveable { mutableStateOf("") }

    Column(modifier = Modifier
        .padding(top = 192.dp, start = 48.dp, end = 48.dp)
    ) {
        NoteIcon()

        LoginForm(
            navController,
            textEmail,
            textPassword,
            onEmailValueChange = { textEmail = it },
            onPasswordValueChange = { textPassword = it }
        )
        LoginButton(navController, textEmail, textPassword, viewModel)
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
    navController: NavController,
    textEmail: String,
    textPassword: String,
    onEmailValueChange: (String) -> Unit,
    onPasswordValueChange: (String) -> Unit
) {
    Text(
        text = "Login",
        style = MaterialTheme.typography.titleLarge.copy(
            fontWeight = FontWeight.Light
        ),
        modifier = Modifier.padding(top = 96.dp)
    )

    BasicTextField(
        modifier = Modifier
            .padding(top = 12.dp)
            .fillMaxWidth(),
        value = textEmail,
        onValueChange = { onEmailValueChange(it) },
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
        value = textPassword,
        onValueChange = { onPasswordValueChange(it) },
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
fun LoginButton(
    navController: NavController,
    textEmail: String,
    textPassword: String,
    viewModel: ApiViewModel
) {
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
                viewModel.login(email = textEmail, password = textPassword)
                val test = viewModel.loginResponse
                if (test != null) {
                    if (test.success) {
                        navController.navigate(route = Screen.List.route)
                    }
                }
            }
        ) {
            Text("Login")
        }
    }
}