package com.florian.ayrton.laboratoriocalificado03.api

import com.florian.ayrton.laboratoriocalificado03.model.TeachersResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("https://private-effe28-tecsup1.apiary-mock.com/list/teacher") // Cambia esto por la ruta real de tu API
    suspend fun getTeachers(): Response<TeachersResponse>
}