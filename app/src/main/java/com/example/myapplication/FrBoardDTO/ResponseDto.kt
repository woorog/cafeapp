package com.example.myapplication.FrBoardDTO

import com.google.gson.annotations.SerializedName

data class ResponseDto(
    @SerializedName("anscnt") val anscnt: Int,
    @SerializedName("data") val data:List<ResponseData>

)