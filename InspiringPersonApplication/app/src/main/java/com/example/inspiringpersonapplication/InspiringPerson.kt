package com.example.inspiringpersonapplication
import java.io.Serializable

data class InspiringPerson (
    val name: String,
    val image: String,
    val dateOfBirthAndDeath: String,
    val description: String
    ) : Serializable