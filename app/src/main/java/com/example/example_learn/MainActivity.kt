package com.example.example_learn

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.example_learn.databinding.ActivityMainBinding
import com.example.example_learn.retrofit.RetrofitActivity
import com.example.example_learn.set_flags.A_Activity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRetrofit2.setOnClickListener { retrofit2() }
        binding.btnSetFlags.setOnClickListener { setFlag() }
        val bundle = intent.extras
        if (bundle!= null){
            Log.d("tesst bundle ","ok")
        }
    }

    private fun setFlag() {
        val intent = Intent(this,A_Activity::class.java)
        startActivity(intent)
    }

    private fun retrofit2() {
        val intent = Intent(this,RetrofitActivity::class.java)
        startActivity(intent)
    }
}