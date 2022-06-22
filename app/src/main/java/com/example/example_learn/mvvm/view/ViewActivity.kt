package com.example.example_learn.mvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.example_learn.R
import com.example.example_learn.databinding.ActivityViewBinding
import com.example.example_learn.mvvm.viewmodel.MVVMViewmodel

class ViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityViewBinding
    private lateinit var mvvmViewmodel: MVVMViewmodel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding = DataBindingUtil.setContentView(this,R.layout.activity_view)
        mvvmViewmodel = ViewModelProvider(this)[MVVMViewmodel::class.java]
        binding.lifecycleOwner = this
        binding.viewmodel = mvvmViewmodel
        setupNofication()
    }

    private fun setupNofication() {
        mvvmViewmodel.toast!!.observe(this,Observer{ _toast->
            if (_toast!=null){
                Toast.makeText(this,_toast,Toast.LENGTH_SHORT).show()
            }
        })
    }
}