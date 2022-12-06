package com.saisai.noteapp

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.saisai.noteapp.screens.AddNoteScreen
import com.saisai.noteapp.screens.ListScreen
import com.saisai.noteapp.screens.LoginScreen
import com.saisai.noteapp.screens.RegisterScreen

@Composable
fun SetupNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Login.route
    ) {
        composable(
            route = Screen.Login.route
        ) {
            LoginScreen(navController)
        }

        composable(
            route = Screen.Register.route
        ) {
            RegisterScreen(navController)
        }

        composable(
            route = Screen.List.route
        ) {
            ListScreen(navController)
        }

        composable(
            route = Screen.AddNote.route
        ) {
            AddNoteScreen(navController)
        }
    }
}