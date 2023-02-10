package com.example.myapplication.LoginInfo

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST


interface LoginAPI {
    @POST("v1/signIn")
    fun login(@Body loginInfo: UserLoginInfo): Call<SingleResult>
}