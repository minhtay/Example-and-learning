package com.example.example_learn.mvvm.adpter

import androidx.databinding.BindingAdapter
import com.google.android.material.textfield.TextInputLayout

@BindingAdapter("app:error_message")
fun errorEnable(view: TextInputLayout, message: String?) {
    if (message!=null){
        view.error = message
    }
}
