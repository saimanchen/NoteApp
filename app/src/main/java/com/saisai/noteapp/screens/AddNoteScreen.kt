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
fun AddNoteScreen(
    navController: NavController
) {
    fun titleMaxLength(input: String) = if (input.length > 60) input.substring(0..59) else input
    fun descriptionMaxLength(input: String) = if (input.length > 150) input.substring(0..149) else input

    Column{
        Column(modifier = Modifier.padding(24.dp)) {
            Row() {
                Text(
                    text = "Title",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontWeight = FontWeight.Light
                    ),
                    modifier = Modifier
                        .padding(top = 8.dp, start = 2.dp)
                        .weight(1f)
                )

                Image(
                    painter = painterResource(id = R.drawable.ic_sun),
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .size(width = 30.dp, height = 30.dp)
                )
            }

            var textTitle by rememberSaveable { mutableStateOf("") }

            BasicTextField(
                modifier = Modifier
                    .padding(top = 12.dp)
                    .fillMaxWidth(),
                value = textTitle,
                onValueChange = { textTitle = titleMaxLength(it) },
                textStyle = TextStyle(
                    color = Color.LightGray,
                    fontStyle = FontStyle(12)
                ),
                maxLines = 2
                )
        }

        Divider(
            modifier = Modifier
                .padding(top = 4.dp),
            color = Color.LightGray
        )

        Column(modifier = Modifier.padding(24.dp)) {
            Text(
                text = "Short description",
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontWeight = FontWeight.Light
                ),
                modifier = Modifier.padding(top = 8.dp, start = 2.dp)
            )

            var textDescription by rememberSaveable { mutableStateOf("") }
            BasicTextField(
                modifier = Modifier
                    .padding(top = 12.dp)
                    .fillMaxWidth(),
                value = textDescription, onValueChange = { textDescription = descriptionMaxLength(it) },
                textStyle = TextStyle(
                    color = Color.LightGray,
                    fontStyle = FontStyle(12)
                ),
                maxLines = 6
            )
        }

        Divider(
            modifier = Modifier
                .padding(top = 4.dp),
            color = Color.LightGray
        )

        Column(modifier = Modifier.padding(24.dp)) {
            Text(
                text = "Content",
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontWeight = FontWeight.Light
                ),
                modifier = Modifier.padding(top = 8.dp, start = 2.dp)
            )

            var textContent by rememberSaveable { mutableStateOf("") }
            BasicTextField(
                modifier = Modifier
                    .padding(top = 12.dp)
                    .fillMaxWidth()
                    .weight(1f),
                value = textContent,
                onValueChange = { textContent = it },
                textStyle = TextStyle(
                    color = Color.LightGray,
                    fontStyle = FontStyle(12)
                ),
                maxLines = 100
            )

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Bottom,
                modifier = Modifier
                    .padding(bottom = 25.dp)
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
                        navController.navigate(route = Screen.List.route)
                    }
                ) {
                    Text(text = "Add new note")
                }
            }
        }
    }
}