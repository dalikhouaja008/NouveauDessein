package com.example.nouveaudesseinapp.Entities

import kotlinx.serialization.Serializable

@Serializable
data class UserData(
    val nom: String,
    val cin:String,
    val numTel:String,
    val email: String,
    val password:String
    )