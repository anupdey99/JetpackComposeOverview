package com.anupdey.jetpackcomposeoverview.data.model


import com.google.gson.annotations.SerializedName

data class Owner(
    @SerializedName("avatar_url")
    val avatarUrl: String?,
    @SerializedName("id")
    val id: Int,
    @SerializedName("login")
    val login: String?,
    @SerializedName("type")
    val type: String?
)