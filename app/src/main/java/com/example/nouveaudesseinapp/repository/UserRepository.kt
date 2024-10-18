package com.example.nouveaudesseinapp.repository

import com.example.nouveaudesseinapp.network.ApiService
import com.example.nouveaudesseinapp.network.User
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Response
import okhttp3.ResponseBody

class UserRepository {

    // Initialize Retrofit with your backend URL for emulator
    private val apiService: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl("http://192.168.0.101:2000/") // For emulator
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    // Function to create a new user using the API with error handling
    suspend fun createUser(user: User): Response<User> {
        return try {
            apiService.createUser(user)
        } catch (e: Exception) {
            // Log the error for debugging
            e.printStackTrace()
            Response.error(500, ResponseBody.create(null, "Error creating user"))
        }
    }

}
