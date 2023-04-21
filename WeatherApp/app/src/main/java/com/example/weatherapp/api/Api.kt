package com.example.weatherapp.api

import com.example.weatherapp.models.MockServiseResponse
import retrofit2.Response
import retrofit2.http.GET

interface Api {
    @GET("fce13eed-875f-49f2-93f7-612416b8b265")
    suspend fun getMockServiceResponse(): Response<MockServiseResponse>
}