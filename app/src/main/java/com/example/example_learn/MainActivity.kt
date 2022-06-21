package com.example.example_learn

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.example_learn.base_activity.Activity1
import com.example.example_learn.databinding.ActivityMainBinding
import com.example.example_learn.retrofit.RetrofitActivity

class MainActivity : AppCompatActivity(),View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }



    override fun onClick(view: View) {
        when(view.id){
            R.id.btnBaseActivity->{
                val intent = Intent (this@MainActivity, Activity1::class.java)
                startActivity(intent)

            }
            R.id.btnRetrofit2->{
                val intent = Intent(this,RetrofitActivity::class.java)
                startActivity(intent)
            }
        }
    }
}