package com.example.otpsignup

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface Apiinterface
{
    @FormUrlEncoded
    @POST("register.php")
    fun insertdata(@Field("name") name:String, @Field("email") email:String, @Field("phone") mobile:String, @Field("password") pass:String):Call<Void>

    @FormUrlEncoded
    @POST("login.php")
    fun login(@Field("email") email:String,@Field("pass") pass:String):Call<Void>
}