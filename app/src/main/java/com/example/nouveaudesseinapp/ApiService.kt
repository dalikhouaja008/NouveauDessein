package com.example.nouveaudesseinapp

import com.example.nouveaudesseinapp.Entities.UserData
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("/api/users/create")
     fun createUser(@Body userData: UserData): Call<UserData>
}