package com.example.example_learn.mvvm.viewmodel

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.example_learn.retrofit.api.ClientResponse
import com.example.example_learn.retrofit.api.UserResponse
import com.example.example_learn.retrofit.model.LoginStatus
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*
import kotlin.concurrent.timerTask

class MVVMViewmodel : ViewModel() {

    val username = MutableLiveData<String>()
    val password = MutableLiveData<String>()
    var _errorEmail = MutableLiveData<String>()
    val errorEmail: LiveData<String>
        get() = _errorEmail
    var _errorPass = MutableLiveData<String>()
    val errorPass: LiveData<String>
        get() = _errorPass
    var _toast = MutableLiveData<String>()
    val toast: LiveData<String>
        get() = _toast


    fun checkValid() {
        if (valid()) {
            val retrofitClient = ClientResponse.buildService(UserResponse::class.java)
            val newLoginData = retrofitClient.login("c16c4d96ae7eae09f9e9100902c478ec", username.value.toString(),password.value.toString(),"phone")
            newLoginData.enqueue((object : Callback<LoginStatus> {

                override fun onResponse(call: Call<LoginStatus>, response: Response<LoginStatus>) {
                    if (response.isSuccessful){
                        if(response.body()!!.api_status == 200){
                            Log.d("Login :"," successs ${response.body()!!.api_status}")
                            Timer().schedule(timerTask {
                                _toast.value="loginSuccess"
                            },3000)
                        }else{
                            Log.d("Login :"," fail")
                        }
                    }else{
                        Log.d("Login :"," fail")

                    }
                }

                override fun onFailure(call: Call<LoginStatus>, t: Throwable) {
                    Log.d("Login :"," fail $t")
                }

            }))
        }
    }

    private fun valid(): Boolean {
        val whiteSpace = ".*\\s.*"
        val lenght = password.value.toString().length
        if (username.value == null) {
            _errorEmail.value = "Username not entered"
            return false
        } else {
            _errorEmail.value = ""
        }
        if (username.value!!.matches(whiteSpace.toRegex())) {
            _errorEmail.value = "Username not entered"
            return false
        } else {
            _errorEmail.value = ""
        }
        if (password.value == null) {
            _errorPass.value = "Password not entered"
            return false
        } else {
            _errorPass.value = ""
        }
        if (password.value != null && lenght < 6) {
            _errorPass.value = "Password must be at least 6 characters"
            return false
        } else {
            _errorPass.value = ""
        }

        return true
    }
}