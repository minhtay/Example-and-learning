package com.example.example_learn.retrofit.api

import com.example.example_learn.retrofit.model.LoginStatus
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface UserResponse {
    @FormUrlEncoded
    @POST("api/auth")
    fun login(@Field("server_key") server_key: String,
              @Field("username") username:String,
              @Field("password") password: String,
              @Field("device_type") device_type: String): Call<LoginStatus>

}

