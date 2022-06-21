package com.example.example_learn.base_activity

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Bundle
import android.provider.Settings
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity



abstract class BaseActivity : AppCompatActivity() {

    abstract fun getLayoutID():Int
    abstract fun onCreateActivity(savedInstanceState: Bundle?)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutID())
        onCreateActivity(savedInstanceState)
        checkConnection()
    }

    fun checkConnection(){
        if (!checkForInternet(applicationContext)) {
            alertDiaolog().show()
        }
    }

    private fun alertDiaolog():AlertDialog.Builder{
        val builder = AlertDialog.Builder(this)
        builder.setTitle("No internet connection")
        builder.setMessage("Internet connection is slow or unavailable. Please check your internet settings")
        builder.setPositiveButton("Ok") { _, _ ->}
/*
            startActivity(Intent(Settings.Panel.ACTION_INTERNET_CONNECTIVITY))
*/
        builder.setNegativeButton("Cancel") { _, _ ->}
        return builder
    }


    fun checkForInternet(context: Context): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val network = connectivityManager.activeNetwork ?: return false
        val activeNetwork = connectivityManager.getNetworkCapabilities(network) ?: return false
        return when {
            activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
            activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
            else -> false
        }
    }
}