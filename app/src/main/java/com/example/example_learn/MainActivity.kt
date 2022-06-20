package com.example.example_learn

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.example_learn.databinding.ActivityMainBinding
import com.example.example_learn.retrofit.RetrofitActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRetrofit2.setOnClickListener { retrofit2() }
    }

    private fun retrofit2() {
        val intent = Intent(this,RetrofitActivity::class.java)
        startActivity(intent)
    }
}