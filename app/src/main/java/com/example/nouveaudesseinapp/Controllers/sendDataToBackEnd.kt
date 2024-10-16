package com.example.nouveaudesseinapp.Controllers

/*import com.example.nouveaudesseinapp.Entities.UserData
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.http.ContentType
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import kotlinx.coroutines.runBlocking

suspend fun sendDataToBackend(userData: UserData) {
    // Création du client Http avec ContentNegotiation pour gérer le JSON
    val client = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
            })
        }
    }

    try {
        // Envoi d'une requête POST avec les données JSON
        val response: String = client.post("http://localhost:2000/api/users/create") {
            contentType(ContentType.Application.Json)
            setBody(userData)
        }
        println("Response from server: $response")
    } catch (e: Exception) {
        e.printStackTrace()
    } finally {
        client.close()
    }
}*/

