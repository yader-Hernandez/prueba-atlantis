package com.example.weatherapp.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.models.MockServiseResponse
import com.example.weatherapp.repository.Repository
import com.example.weatherapp.utils.Resource
import kotlinx.coroutines.launch
import retrofit2.Response

class ViewModel (
    app: Application,
    val repository: Repository
) : AndroidViewModel(app){
    val llaves : MutableLiveData<Resource<MockServiseResponse>> = MutableLiveData()

    fun getMockServiceResponse()= viewModelScope.launch {
        llaves.postValue(Resource.Loading())
        val response = repository.getMockServiceResponse()
        llaves.postValue(hadnleMockService(response))
    }

    private fun hadnleMockService(response: Response<MockServiseResponse>): Resource<MockServiseResponse>{
        if (response.isSuccessful){
            response.body()?.let { resultResponse ->
                return Resource.Success(resultResponse)
            }
        }
        return Resource.Error(response.message())
    }
}