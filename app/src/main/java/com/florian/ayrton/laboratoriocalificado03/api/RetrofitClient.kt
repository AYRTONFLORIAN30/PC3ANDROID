package com.florian.ayrton.laboratoriocalificado03.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.florian.ayrton.laboratoriocalificado03.api.ApiService

object RetrofitClient {
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://private-effe28-tecsup1.apiary-mock.com/") // Asegúrate de que tu URL base termine con una barra "/"
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiService: ApiService = retrofit.create(ApiService::class.java)
}
