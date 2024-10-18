package com.example.nouveaudesseinapp.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nouveaudesseinapp.network.User
import com.example.nouveaudesseinapp.repository.UserRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class UserViewModel : ViewModel() {
    private val userRepository = UserRepository()

    // Function to create a user and handle the result in the UI
    fun createUser(user: User, onResult: (Response<User>) -> Unit) {
        viewModelScope.launch {
            Log.d("UserViewModel", "Creating user: $user")
            val response = userRepository.createUser(user)
            Log.d("UserViewModel", "Response: $response")
            onResult(response)
        }
    }

}

