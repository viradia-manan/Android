package com.example.otpsignup

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Apiclient
{
    companion object
    {
        lateinit var retrofit: Retrofit
        var BASE_URL = "https://mananviradia14.000webhostapp.com/API/"

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