package com.example.example_learn.retrofit

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.example_learn.databinding.ActivityRetrofitBinding
import com.example.example_learn.retrofit.api.RetrofitClient
import com.example.example_learn.retrofit.api.UserService
import com.example.example_learn.retrofit.model.LoginMessage
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*
import kotlin.concurrent.timerTask


class RetrofitActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRetrofitBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRetrofitBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.Login.setOnClickListener { if (checkValid())login() }
        binding.btnBack.setOnClickListener { finish() }

    }

    private fun checkValid():Boolean{
        if (binding.edtEmail.text.toString() == ""){
            binding.tilEmail.error = "Email not entered"
            return false
        }
        if (binding.edtPassword.text.toString() == ""){
            binding.tilPassword.error = "Password not entered"
            return false
        }
        return true
    }

    private fun login() {
        val retrofitClient = RetrofitClient.buildService(UserService::class.java)
        val newLoginData = retrofitClient.login("c16c4d96ae7eae09f9e9100902c478ec",binding.edtEmail.text.toString(),binding.edtPassword.text.toString())
        newLoginData.enqueue((object : Callback<LoginMessage> {

            override fun onResponse(call: Call<LoginMessage>, response: Response<LoginMessage>) {
                if (response.isSuccessful){
                    if(response.body()!!.api_status == 200){
                        Log.d("Login :"," successs ${response.body()!!.api_status}")
                        Toast.makeText(this@RetrofitActivity,"Login Success",Toast.LENGTH_SHORT).show()
                        Timer().schedule(timerTask {
                            loginSuccessActivity()
                        },3000)
                    }
                    if (response.body()!!.api_status == 400){
                        Log.d("Login :"," fail")
                        Toast.makeText(this@RetrofitActivity,"Login fail. ${response.body()!!.errors.error_text}",Toast.LENGTH_SHORT).show()
                    }
                }else{
                    Log.d("Login :"," fail")
                    Toast.makeText(this@RetrofitActivity,"Login fail. Can't note connect server",Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<LoginMessage>, t: Throwable) {
                Log.d("Login :"," fail $t")
                Toast.makeText(this@RetrofitActivity,"Login fail. Can't note connect server",Toast.LENGTH_SHORT).show()
            }

        }))

    }

    private fun loginSuccessActivity() {
        val intent = Intent(this,LoginSuccessActivity::class.java)
        startActivity(intent)
    }
}