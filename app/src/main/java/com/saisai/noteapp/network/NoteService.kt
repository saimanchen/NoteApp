package com.saisai.noteapp.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NoteService {

    companion object {
        // school IP
        private const val BASE_URL = "http://172.16.241.139:8080/"

        // home IP
        //private const val BASE_URL = "http://192.168.0.103:8080/"



        private val okHttpClient: OkHttpClient = OkHttpClient()
            .newBuilder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()

        fun getInstance(): Retrofit {
            return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}