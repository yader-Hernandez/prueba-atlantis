package com.example.weatherapp.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class MockServiseResponse(
    @SerializedName("message")
    @Expose
    val message: String,
    @SerializedName("user_id")
    @Expose
    val userID: Int,
    @SerializedName("name")
    @Expose
    val name: String,
    @SerializedName("email")
    @Expose
    val email: String,
    @SerializedName("mobile")
    @Expose
    val mobile: String,
    @SerializedName("profile_details")
    @Expose
    val profileDetails: ProfileDetails,
    @SerializedName("data_list")
    @Expose
    val dataList: List<DataList>,
)

data class ProfileDetails(
    @SerializedName("is_profile_complete")
    @Expose
    val isProfileComplete: Boolean,
    @SerializedName("rating")
    @Expose
    val rating: Double,
)

data class DataList(
    @SerializedName("id")
    @Expose
    val rating: Int,
    @SerializedName("value")
    @Expose
    val value: String,
)
