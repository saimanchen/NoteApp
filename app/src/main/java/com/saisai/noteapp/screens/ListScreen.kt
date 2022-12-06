package com.saisai.noteapp.screens

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.saisai.noteapp.R
import com.saisai.noteapp.data.Note

@Composable
fun ListScreen() {
    Column {
        ListScreenHeader()
        NoteList()
    }
}

@Composable
fun ListScreenHeader() {

    Column{
        Row(
            modifier = Modifier
                .padding(top = 20.dp, end = 20.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_logout),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .size(width = 40.dp, height = 40.dp)
                    .offset(x = -(10.dp))
                    .clickable { println("logoutBtn") }
            )

            Image(
                painter = painterResource(id = R.drawable.ic_add),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .size(width = 40.dp, height = 40.dp)
                    .clickable { println("addBtn") }
            )
        }

        Divider(color = Color.Gray, modifier = Modifier.padding(top = 20.dp))
    }
}

@Composable
fun NoteList(
    notes: List<Note> = listOf(
        Note(
            title = "Lorem ipsum 1",
            description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec a ante bibendum, hendrerit tortor vitae, vehicula lorem.",
            content = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec a ante bibendum, hendrerit tortor vitae, vehicula lorem. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec a ante bibendum, hendrerit tortor vitae, vehicula lorem. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec a ante bibendum, hendrerit tortor vitae, vehicula lorem."
        ),
        Note(
            title = "Lorem ipsum 2",
            description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec a ante bibendum, hendrerit tortor vitae, vehicula lorem.",
            content = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec a ante bibendum, hendrerit tortor vitae, vehicula lorem. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec a ante bibendum, hendrerit tortor vitae, vehicula lorem. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec a ante bibendum, hendrerit tortor vitae, vehicula lorem. "
        ),
        Note(
            title = "Lorem ipsum 3",
            description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec a ante bibendum, hendrerit tortor vitae, vehicula lorem.",
            content = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec a ante bibendum, hendrerit tortor vitae, vehicula lorem.\nLorem ipsum dolor sit amet, consectetur adipiscing elit. Donec a ante bibendum, hendrerit tortor vitae, vehicula lorem.\nLorem ipsum dolor sit amet, consectetur adipiscing elit. Donec a ante bibendum, hendrerit tortor vitae, vehicula lorem.\n"
        ),
        Note(
            title = "Lorem ipsum 4",
            description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec a ante bibendum, hendrerit tortor vitae, vehicula lorem.",
            content = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec a ante bibendum, hendrerit tortor vitae, vehicula lorem.\nLorem ipsum dolor sit amet, consectetur adipiscing elit. Donec a ante bibendum, hendrerit tortor vitae, vehicula lorem.\nLorem ipsum dolor sit amet, consectetur adipiscing elit. Donec a ante bibendum, hendrerit tortor vitae, vehicula lorem.\n"
        ),
    )
) {
    LazyColumn(modifier = Modifier.padding(vertical = 4.dp)) {
        items(items = notes) { (title, description, content) ->
            NoteItem(title = title, content = content, description = description)
        }
    }
}

@Composable
fun NoteItem(
    title: String,
    content: String,
    description: String
) {
    var expanded by rememberSaveable { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .padding(start = 12.dp)
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioLowBouncy,
                    stiffness = Spring.StiffnessLow
                )
            )
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(12.dp)
        ) {

            Text(
                text = title,
                textAlign = TextAlign.Justify,
                style = MaterialTheme.typography.titleSmall.copy(
                    color = Color.LightGray,
                    fontWeight = FontWeight.Light
                )
            )

            Column(modifier = Modifier.padding(top = 10.dp)) {
                Text(
                    text = "Short Description",
                    style = MaterialTheme.typography.bodySmall.copy(
                        color = Color.Gray,
                        fontWeight = FontWeight.Light
                    )
                )
                Text(
                    text = description,
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = Color.LightGray,
                        fontWeight = FontWeight.Light
                    )
                )
            }

            if (expanded) {
                Column(modifier = Modifier.padding(top = 10.dp, bottom = 10.dp)) {
                    Text(
                        text = "Content",
                        style = MaterialTheme.typography.bodySmall.copy(
                            color = Color.Gray,
                            fontWeight = FontWeight.Light
                        )
                    )
                    Text(
                        text = content,
                        style = MaterialTheme.typography.bodyMedium.copy(
                            color = Color.LightGray,
                            fontWeight = FontWeight.Light
                        )
                    )
                }
            }
        }

        IconButton(onClick = { expanded = !expanded }) {
            Icon(
                imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
                contentDescription = null
            )
        }
    }

    Column {
        Divider(
            color = Color.Gray
        )
    }
}