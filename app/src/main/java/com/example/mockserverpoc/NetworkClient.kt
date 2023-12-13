package com.example.mockserverpoc

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object NetworkClient {

    const val BASE_URL = "http://10.0.2.2:2727/"  //https://reqres.in -- real server

    fun getClient(): Retrofit {
        val client = OkHttpClient.Builder().build()
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

}