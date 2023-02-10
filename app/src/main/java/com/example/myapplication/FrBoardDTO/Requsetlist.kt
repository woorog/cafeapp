package com.example.myapplication.FrBoardDTO

data class Requestlist (
    val length: Int=20,
   val reqsearchObj: reqSearchObj,
    val start: Int=0,
)

data class reqSearchObj (
    val boardCn: String,
    val boardSj: String,
    val boardTy: String,
    val creatDEnd: String="2022-06-28T08:48:15.289Z",
    val creatDStart: String="2022-06-28T08:48:15.289Z",
    val wrterLoginId: String,
    val wrterNcnm: String
)