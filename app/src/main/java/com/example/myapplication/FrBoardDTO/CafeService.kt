package com.example.myapplication.FrBoardDTO

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface CafeService {
    @POST("v1/free-boards/Dt")
    fun service(@Body bodyInfo: Requestlist): Call<ResponseDto>

}