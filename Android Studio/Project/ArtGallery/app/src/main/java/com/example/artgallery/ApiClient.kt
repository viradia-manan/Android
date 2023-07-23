package com.example.artgallery

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient
{
    companion object
    {
        lateinit var retrofit: Retrofit
        var BASE_URL = "https://mananviradia14.000webhostapp.com/art_gallery/"

        fun getapiclient():Retrofit
        {
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit
        }
    }
}