package com.example.example_learn.set_flags

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.example_learn.R

class B_Activity : AppCompatActivity() , View.OnClickListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b)
    }
    override fun onClick (view: View){
        when(view.id){
            R.id.button1-> {
                val intent = Intent(this,A_Activity::class.java)
                val mBundle = Bundle()
                intent.putExtras(mBundle)
                intent.flags = ( Intent.FLAG_ACTIVITY_NEW_TASK); (Intent.FLAG_ACTIVITY_CLEAR_TOP)
                startActivity(intent)
                finish()
            }
            R.id.button ->{
                finish()
            }

        }
    }
}