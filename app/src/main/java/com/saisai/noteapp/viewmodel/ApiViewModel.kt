package com.saisai.noteapp.viewmodel

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.saisai.noteapp.data.Note
import com.saisai.noteapp.data.request.LoginRequest
import com.saisai.noteapp.data.response.LoginResponse
import com.saisai.noteapp.network.NoteService
import com.saisai.noteapp.network.NoteApi
import kotlinx.coroutines.launch

class ApiViewModel: ViewModel() {

    private val retroInstance = NoteService.getInstance()
    private val retroService = retroInstance.create(NoteApi::class.java)

    private var errorMessage: String by mutableStateOf("")

    private val _loginResponse = mutableStateOf<LoginResponse?>(null)
    val loginResponse: LoginResponse?
        get() = _loginResponse.value

    private var _token: String by mutableStateOf("")
    val token: String
        get() = _token

    // note list
    private val _notes = mutableStateListOf<Note>()
    val notes: List<Note>
        get() = _notes


    fun login(email: String, password: String) {
        viewModelScope.launch {
            try {
                val loginRequest = LoginRequest(email, password)
                println(loginRequest)

                val response = retroService.loginUser(loginRequest)
                _loginResponse.value = response
                _token = response.token

            } catch (e: Exception) {
                errorMessage = e.message.toString()
                println(errorMessage)
            }
        }
    }

    fun getNotes(token: String) {
        viewModelScope.launch {
            try {
                _notes.clear()
                _notes.addAll(retroService.getNotesList("Bearer $token"))

                println(notes.toList().toString())
            } catch (e: Exception) {
                errorMessage = e.message.toString()
                println(errorMessage)
            }
        }
    }
}