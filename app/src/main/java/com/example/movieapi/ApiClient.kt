package com.example.movieapi

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {

   companion object {

        val BASE_URL = "https://api.themoviedb.org/3/movie/"
        val BASE_IMAGE_URL = "https://image.tmdb.org/t/p/w500"
        lateinit var retrofit: Retrofit

        fun getApiClient(): Retrofit {
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit
        }

    }

}