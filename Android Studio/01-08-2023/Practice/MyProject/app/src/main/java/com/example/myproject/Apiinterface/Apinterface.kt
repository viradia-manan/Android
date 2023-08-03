package com.example.myproject.Apiinterface

import android.telecom.Call
import com.example.myproject.Model.RegisterModel
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface Apinterface
{
    @FormUrlEncoded
    @POST("user_signup.php")
    fun registerdetail(
        @Field("firstname") firstname: String?,
        @Field("lastname") lastname: String?,
        @Field("gender") gender:String?,
        @Field("email") email: String?,
        @Field("phone") mobile: String?,
        @Field("password") password: String?,
    ): retrofit2.Call<Void>

    @FormUrlEncoded
    @POST("user_login.php")
    fun logindata(
        @Field("phone") mobile: String?,
        @Field("password") password: String?
    ): retrofit2.Call<RegisterModel>

}