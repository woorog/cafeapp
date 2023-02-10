package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.myapplication.LoginInfo.LoginAPI
import com.example.myapplication.LoginInfo.SingleResult
import com.example.myapplication.LoginInfo.UserLoginInfo
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intent = Intent(this, SubActivity::class.java)

        button.setOnClickListener() {
            Toast
                .makeText(this, "아이디찾기", Toast.LENGTH_SHORT)
                .show()
        } //id
        button2.setOnClickListener() {
            Toast
                .makeText(this, "비밀번호찾기", Toast.LENGTH_SHORT)
                .show()
        } //ps
        button3.setOnClickListener() {
            Toast
                .makeText(this, "회원가입", Toast.LENGTH_SHORT)
                .show()
        }//member



        loginbutton.setOnClickListener{
            login(editTextTextid.text.toString(), editTextTextpass.text.toString(), { result ->
                Log.d("SingleResult", result.toString())
                Toast
                    .makeText(this, "로그인되었습니다", Toast.LENGTH_SHORT)
                    .show()
                val intent = Intent(this, SubActivity::class.java)
                startActivity(intent)
            })
        }


    }
     fun login(loginId: String, loginPassword: String, callback: (SingleResult) -> Unit) {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://yhapidev.teamfresh.co.kr/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val loginAPI = retrofit.create(LoginAPI::class.java)

        val call = loginAPI.login(UserLoginInfo(loginId, loginPassword))
        call.enqueue(object : Callback<SingleResult> {
            override fun onResponse(call: Call<SingleResult>, response: Response<SingleResult>) {
                val result = response.body()
                if (result != null) {
                    Log.d("SingleResult", result.toString())

                    callback(result)


                }
            }

            override fun onFailure(call: Call<SingleResult>, t: Throwable) {
                // handle error
            }
        })
    }

}

