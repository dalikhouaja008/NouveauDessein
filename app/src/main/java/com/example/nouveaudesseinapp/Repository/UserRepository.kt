package com.example.nouveaudesseinapp.Repository

import com.example.nouveaudesseinapp.ApiService
import com.example.nouveaudesseinapp.Entities.UserData
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class UserRepository {

    // Create Retrofit instance
    private val retrofit = Retrofit.Builder()
        .baseUrl("http://localhost:2000")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    private val apiService = retrofit.create(ApiService::class.java)

     fun createUser(userData: UserData, onResult: (Boolean) -> Unit) {
        val call = apiService.createUser(userData)

        // Enqueue the call to handle it asynchronously
        call.enqueue(object : retrofit2.Callback<UserData> {
            override fun onResponse(call: retrofit2.Call<UserData>, response: retrofit2.Response<UserData>) {
                if (response.isSuccessful) {
                    onResult(true) // Pass back the result
                } else {
                    onResult(false)
                }
            }

            override fun onFailure(call: retrofit2.Call<UserData>, t: Throwable) {
                t.printStackTrace()
                onResult(false)
            }
        })
    }
}

