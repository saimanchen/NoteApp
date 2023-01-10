package com.saisai.noteapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.saisai.noteapp.screens.AddNoteScreen
import com.saisai.noteapp.screens.ListScreen
import com.saisai.noteapp.screens.LoginScreen
import com.saisai.noteapp.screens.RegisterScreen
import com.saisai.noteapp.viewmodel.ApiViewModel

@Composable
fun SetupNavGraph(
    navController: NavHostController, viewModel: ApiViewModel
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Login.route
    ) {
        composable(
            route = Screen.Login.route
        ) {
            LoginScreen(navController, viewModel)
        }

        composable(
            route = Screen.Register.route
        ) {
            RegisterScreen(navController)
        }

        composable(
            route = Screen.List.route
        ) {
            ListScreen(navController, viewModel)
        }

        composable(
            route = Screen.AddNote.route
        ) {
            AddNoteScreen(navController)
        }
    }
}