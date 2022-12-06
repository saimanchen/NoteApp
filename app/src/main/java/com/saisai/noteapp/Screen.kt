package com.saisai.noteapp

sealed class Screen(val route: String) {
    object Login: Screen(route = "login_screen")
    object Register: Screen(route = "register_screen")
    object List: Screen(route = "list_screen")
    object AddNote: Screen(route = "add_note_screen")
}
