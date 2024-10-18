package com.example.nouveaudesseinapp.network

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

// Data model representing a user.
data class User(
    val nom: String,
    val cin: String,
    val numTel: String,
    val email: String,
    val password: String,
    val role: String = "user",  // Default role is "user"
    val discount: Int = 0       // Default discount is 0
)

// API interface for user-related endpoints
interface ApiService {
    @POST("api/users/create")  // Adjust this endpoint according to your backend
    suspend fun createUser(@Body user: User): Response<User>
}