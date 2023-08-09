package com.baseapk.artgallery.ApiInterface

import com.baseapk.artgallery.Model.CategoryModel
import com.baseapk.artgallery.Model.RegisterModel
import com.baseapk.artgallery.Model.imageslider
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiInterface
{
    @FormUrlEncoded
    @POST("register.php")
    fun signUp(@Field("name") name:String, @Field("email") email:String, @Field("password") pass: String?): Call<Void>

    @FormUrlEncoded
    @POST("login.php")
    fun login(@Field("email") email:String, @Field("password") pass: String?): Call<RegisterModel>

    @GET("c_view.php")
    fun category_data() : Call<List<CategoryModel>>

    @GET("imgslider.php")
    fun imgslider(): Call<List<imageslider>>

   /* @GET("product_view.php")
    fun product_data(): Call<List<ProductModel>>*/
}