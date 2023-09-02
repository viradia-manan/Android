package com.baseapk.artgallery.Apiinterface

import com.baseapk.artgallery.Model.CartModel
import com.baseapk.artgallery.Model.CategoryModel
import com.baseapk.artgallery.Model.ProductModel
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

    @GET("product_colorfull_art_view.php")
    fun product_data(): Call<List<ProductModel>>

    @GET("product_blackandwhite_art_view.php")
    fun product_bw_data(): Call<List<ProductModel>>

    @GET("product_sketch_art_view.php")
    fun product_sketch_data(): Call<List<ProductModel>>

    @FormUrlEncoded
    @POST("fav_add.php")
    fun fav_add(@Field("name") name:String, @Field("price") price:String, @Field("url") image:String, @Field("email") email:String):Call<Void>

    @FormUrlEncoded
    @POST("deletecart.php")
    fun deletecart(@Field("email") email: String): Call<Void>

    @GET("fav_view.php")
    fun cart_view(): Call<List<CartModel>>



}