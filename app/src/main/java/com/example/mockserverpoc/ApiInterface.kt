package com.example.mockserverpoc

import com.example.mockserverpoc.model.UserList
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("/api/users")
    fun doGetUserList(): Call<UserList?>?

}