package com.example.example_learn.base_activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.example.example_learn.R

class Activity1 : BaseActivity(),View.OnClickListener {

    override fun getLayoutID(): Int {
        return R.layout.activity_base1
    }

    override fun onCreateActivity(savedInstanceState: Bundle?) {
        checkConnection()
    }

    override fun onClick(view: View) {
        when(view.id){
            R.id.buttonA1->{
                val intent = Intent(this,Activity2::class.java)
                startActivity(intent)
            }
        }
    }


}