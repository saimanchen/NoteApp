package com.saisai.noteapp.data.response

data class LoginResponse(
    val success: Boolean,
    val message: String,
    val token: String
)
