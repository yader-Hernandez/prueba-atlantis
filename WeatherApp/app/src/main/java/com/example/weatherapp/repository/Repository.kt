package com.example.weatherapp.repository

import com.example.weatherapp.api.RetrofitInstance

class Repository {
    suspend fun getMockServiceResponse() = RetrofitInstance.api.getMockServiceResponse()
}