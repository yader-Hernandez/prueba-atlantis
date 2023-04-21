package com.example.weatherapp

import android.app.Application
import com.example.weatherapp.utils.Prefs

class MainActivity : Application(){
    companion object {
        lateinit var prefs: Prefs
    }
    override fun onCreate() {
        super.onCreate()
        prefs = Prefs(applicationContext)
    }
}