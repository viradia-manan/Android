package com.example.retrofitcrud

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient
{
    companion object
    {
        var retrofit:Retrofit?=null
        var BASE_URL="https://vyasprakruti.000webhostapp.com/mobileapi/"

        fun getapiclient():Retrofit?
        {
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit
        }
    }
}