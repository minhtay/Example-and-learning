package com.example.example_learn.base_activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.example.example_learn.R

class Activity2 : BaseActivity(),View.OnClickListener {

    override fun getLayoutID(): Int {
        return R.layout.activity_base2
    }

    override fun onCreateActivity(savedInstanceState: Bundle?) {
        updateUi()
    }



    private fun updateUi() {
        val tv = findViewById<TextView>(R.id.textView1)
        val layout = findViewById<ConstraintLayout>(R.id.baseActivity2)
        if (checkForInternet(applicationContext)){
            tv.text = "Good connection status"
            layout.setBackgroundColor(ContextCompat.getColor(this,R.color.green))
        }else{
            tv.text = "Bad connection status"
            layout.setBackgroundColor(ContextCompat.getColor(this,R.color.red))
        }
    }

    override fun onClick(view: View) {
        when(view.id){
            R.id.buttonA2->{
                val intent = Intent(this,Activity1::class.java)
                startActivity(intent)
                finish()
            }
        }
    }

}