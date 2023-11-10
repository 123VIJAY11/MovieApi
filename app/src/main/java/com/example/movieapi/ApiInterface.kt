package com.example.movieapi

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface ApiInterface {

    @GET("now_playing")
    fun getNowplainging(
        @Header("Authorization") auth:String
    ) : Call<NowPlayingModel>


}