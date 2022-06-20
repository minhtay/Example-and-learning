package com.example.example_learn.retrofit

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.example_learn.databinding.ActivityLoginSuccessBinding

class LoginSuccessActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginSuccessBinding
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginSuccessBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.text.text = " Login success"
    }
}