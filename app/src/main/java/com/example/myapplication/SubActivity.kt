package com.example.myapplication

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.FrBoardDTO.*
import com.example.myapplication.databinding.ActivitySubBinding
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory


class SubActivity : AppCompatActivity() {


    private lateinit var binding: ActivitySubBinding
    private lateinit var cafeService: CafeService
    private lateinit var adapter: ProfileAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySubBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initCafeRecyclerView()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://yhapidev.teamfresh.co.kr/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        cafeService = retrofit.create(CafeService::class.java)
/*
        cafeService.service(Requestlist(
            length = 20,
            start = 0,
            reqsearchObj = reqSearchObj(
                boardCn = "",
                boardSj = "",
                boardTy = "",
                creatDEnd = "2022-06-28T08:48:15.289Z",
                creatDStart = "2022-06-28T08:48:15.289Z",
                wrterLoginId = "",
                wrterNcnm = "")))
            .enqueue(object: Callback<ResponseDto> {
                override fun onResponse( //true.
                    call: Call<ResponseDto>,
                    response: Response<ResponseDto>
                ) {

                    if(response.isSuccessful.not()){
                        Log.e(TAG,"error")
                        return
                    }
                    response.body()?.let {
                        Log.d(TAG,it.data.toString())


                        it.data.forEach{data ->
                            Log.d(TAG,data.toString())

                        }
                        adapter.submitList(it.data)

                    }
                }

                override fun onFailure(call: Call<ResponseDto>, t: Throwable) {
                    Log.e(TAG,t.toString())
                }


            })*/



    }

    private fun initCafeRecyclerView() {
        adapter= ProfileAdapter()
        binding.cafeRecyclerView.layoutManager=LinearLayoutManager(this)
        binding.cafeRecyclerView.adapter=adapter
    }


}








