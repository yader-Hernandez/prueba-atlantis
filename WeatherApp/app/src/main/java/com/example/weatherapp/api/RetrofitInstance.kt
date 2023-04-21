package com.example.weatherapp.api

import com.example.weatherapp.utils.Constants.Companion.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitInstance {
    companion object{
        private val  retrofit by lazy { //Perezosa significa que solo inicializamos esto aquí una vez.
            val logging= HttpLoggingInterceptor()
            /* esta dependencia del LOGGING INTERCEPTOR HTTP puede registrar respuestas de actualización
            esto será útil para depurar el código
             */

            logging.setLevel(HttpLoggingInterceptor.Level.BODY) // Se visualiza la respuesta

            //network client
            val client= OkHttpClient
                .Builder()
                .connectTimeout(1000, TimeUnit.SECONDS)
                .readTimeout(1000, TimeUnit.SECONDS)
                .addInterceptor(logging)
                .build()

            //Pasar al cliente para actualizar instancia
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())//addConverterFactory se usa para determinar cómo se debe interpretar la respuesta y convertirla en un objeto kotlin
                .client(client)
                .build()
        }

        // obtener una instancia de API del generador de modificaciones
        //objeto API
        // esto se puede usar desde cualquier lugar para hacer una solicitud de red
        val api by lazy {
            retrofit.create(Api::class.java)
        }
    }
}