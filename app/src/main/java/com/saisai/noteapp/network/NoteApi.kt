package com.saisai.noteapp.network

import com.saisai.noteapp.data.request.DeleteNoteRequest
import com.saisai.noteapp.data.response.LoginResponse
import com.saisai.noteapp.data.Note
import com.saisai.noteapp.data.request.LoginRequest
import com.saisai.noteapp.data.response.NoteResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.HTTP
import retrofit2.http.Header
import retrofit2.http.POST

interface NoteApi {

    @POST("login")
    suspend fun loginUser(@Body loginRequest: LoginRequest): LoginResponse

    @GET("notes")
    suspend fun getNotesList(@Header("Authorization") token: String): List<Note>

    // not implemented
    @POST("notes")
    fun postNote(@Body note: Note): Call<NoteResponse>

    @HTTP(method = "DELETE", path = "notes", hasBody = true)
    fun deleteBook(@Body noteTitle: DeleteNoteRequest): Call<NoteResponse>
}