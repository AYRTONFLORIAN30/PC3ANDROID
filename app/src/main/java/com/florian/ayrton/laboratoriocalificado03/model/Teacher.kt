package com.florian.ayrton.laboratoriocalificado03.model

data class Teacher(
    val name: String,
    val lastName: String,
    val imageUrl: String,  // Asegúrate que se llama 'imageUrl' y no 'photo' u otro nombre
    val phone: String,
    val email: String
)
