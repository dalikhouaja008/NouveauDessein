package com.example.nouveaudesseinapp

import com.example.nouveaudesseinapp.Entities.Event
import com.google.gson.Gson


// Fonction d'extension pour sérialiser l'objet Event en JSON
fun Event.toJson(): String = Gson().toJson(this)

// Fonction d'extension pour désérialiser une chaîne JSON en objet Event
fun String.toEvent(): Event = Gson().fromJson(this, Event::class.java)