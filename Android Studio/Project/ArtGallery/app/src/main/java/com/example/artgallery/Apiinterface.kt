package com.example.artgallery

import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.gson.annotations.SerializedName
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface Apiinterface
{
    @FormUrlEncoded
    @POST("register.php")
    fun signIn(@Body googleSignInAccount: GoogleSignInAccount): Call<SignInResponse>
}

data class SignInResponse(
    @SerializedName("id") val id: String,
    @SerializedName("email") val email: String,
    @SerializedName("name") val name: String
)