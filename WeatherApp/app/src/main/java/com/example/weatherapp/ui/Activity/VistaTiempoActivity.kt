package com.example.weatherapp.ui.Activity

import android.Manifest
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import com.example.weatherapp.R
import com.example.weatherapp.databinding.ActivityVistaTiempoBinding
import com.example.weatherapp.repository.Repository
import com.example.weatherapp.ui.ViewModel
import com.example.weatherapp.ui.ViewModelProviderFactory
import com.example.weatherapp.utils.Constants
import com.vmadalin.easypermissions.EasyPermissions

class VistaTiempoActivity : AppCompatActivity() {

    private lateinit var vBind: ActivityVistaTiempoBinding
    private val vModel: ViewModel by viewModels {
        ViewModelProviderFactory(application, Repository())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vBind = ActivityVistaTiempoBinding.inflate(layoutInflater)
        setContentView(vBind.root)

        registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()){

        }.launch(arrayOf(
            Manifest.permission.ACCESS_FINE_LOCATION,
        ))
        requestAccessFineLocationPermission()
    }

    private fun requestAccessFineLocationPermission(){
        EasyPermissions.requestPermissions(
            this,
            "Se necesita el permiso de localizacion",
            Constants.PERMISSION_REQUEST_CODE,
            Manifest.permission.ACCESS_FINE_LOCATION
        )
    }
}