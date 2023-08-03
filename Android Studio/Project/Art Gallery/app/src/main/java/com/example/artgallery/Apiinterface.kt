package com.example.artgallery

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import retrofit2.http.Query

interface Apiinterface
{
    @FormUrlEncoded
    @POST("register.php")
    fun signUp(@Field("name") name:String, @Field("email") email:String, @Field("password") pass: String?): Call<Void>

    @FormUrlEncoded
    @POST("login.php")
    fun login(@Field("email") email:String, @Field("password") pass: String?): Call<RegisterModel>
}
