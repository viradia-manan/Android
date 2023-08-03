package com.example.myproject.ApiClient

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient
{
    companion object {

        var BASE_URL = "https://mananviradia14.000webhostapp.com/myproject/"
        var retrofit: Retrofit? = null
        fun getapiclient(): Retrofit? {

            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit
        }
    }
}