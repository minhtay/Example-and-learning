package com.example.example_learn.set_flags

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import com.example.example_learn.R

class A_Activity : AppCompatActivity(),View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_a)

        val bundle = intent.extras
        if (bundle!= null){
            Log.d("tesst bundel","ok")
        }
    }
    override fun onClick (view: View){
        when(view.id){
            R.id.button1-> {
                val intent = Intent(this,B_Activity::class.java)
                startActivity(intent)
            }
            R.id.button ->{
                finish()
            }

        }
    }
}