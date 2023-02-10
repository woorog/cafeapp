package com.example.myapplication.FrBoardDTO

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class ResponseData(
    val length: Int,
    val searchObj: FrBoardDTOReq,
    val start: Int
)

data class FrBoardDTOReq(
    val code: Int,
    val data: FrBoardDTORes,
    val draw: Int,
    val drawfromDate: String,
    val length: Int,
    val msg: String,
    val offset: Long,
    val pageNumber: Int,
    val pageSize: Int,
    val paged: Boolean,
    val recordsFiltered: Long,
    val recordsTotal: Long,
    val searchDate: String,

)
data class FrBoardDTORes(
    val anscnt: Int,
    val bkmkYn: String,
    val boardCn: String,
    val boardCnFlePth: String,
    val boardInfoSeqNo: Int,
    val boardSj: String,
    val boardThumbPth: String,
    val boardTy: String,
    val boardTyCode: String,
    val creatDEnd: String,
    val creatDStart: String,
    val creatDt: String,
    val infoCntntsTyCode: String,
    val likcnt: Int,
    val likeYn: String,
    val rdcnt: Int,
    val updtDt: String,
    val updusrNcnm: String,
    val updusrSeqNo: Int,
    val userProfileFilePth: String,
    val wrterLoginId: String,
    val wrterNcnm: String,
    val wrterSeqNo: Int
)