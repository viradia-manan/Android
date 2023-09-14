package com.baseapk.artgallery.ApiInterface

import com.baseapk.artgallery.Model.CartModel
import com.baseapk.artgallery.Model.CategoryModel
import com.baseapk.artgallery.Model.OrderModel
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
    fun fav_add(@Field("product_name") product_name:String, @Field("product_price") product_price:String, @Field("img") img:String, @Field("product_email") product_email:String):Call<Void>

    @FormUrlEncoded
    @POST("deletecart.php")
    fun deletecart(@Field("email") email: String): Call<Void>

    @FormUrlEncoded
    @POST("fav_view.php")
    fun cart_view(@Field("product_email") product_email: String): Call<List<CartModel>>

    @FormUrlEncoded
    @POST("pay.php")
    fun payment(@Field("product_image")product_image: String,@Field("email") email: String, @Field("product_name") product_name: String,@Field("product_price") product_price: String,@Field("payment") payment:String): Call<Void>

    @FormUrlEncoded
    @POST("order_cancel.php")
    fun deletedata(@Field("id")id:Int): Call<Void>

    @FormUrlEncoded
    @POST("pay_view.php")
    fun view(@Field("email")email: String): Call<List<OrderModel>>
}