package com.example.example_learn

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.example_learn.base_activity.Activity1
import com.example.example_learn.mvvm.view.ViewActivity
import com.example.example_learn.retrofit.RetrofitActivity

class MainActivity : AppCompatActivity(),View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /*binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)*/
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
            R.id.btnMVVM->{
                val intent = Intent(this@MainActivity, ViewActivity::class.java)
                startActivity(intent)
            }
        }
    }
}