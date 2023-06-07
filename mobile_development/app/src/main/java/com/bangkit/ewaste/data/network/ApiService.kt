package com.bangkit.ewaste.data.network

import com.bangkit.ewaste.data.response.user.LoginResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.POST

interface ApiService {

    @POST("login")
    fun login(
        @Field("email") email : String,
        @Field("password") password : String
    ) : Call<LoginResponse>

}