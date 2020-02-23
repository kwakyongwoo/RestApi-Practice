package com.example.restapi.data

import com.google.gson.annotations.SerializedName

data class UserRepos(
    @SerializedName("id") val id: String,
    @SerializedName("name") var name: String,
    @SerializedName("html_url") var url: String,
    @SerializedName("created_at") var createDate: String,
    @SerializedName("language") var language: String
) {
    init {
        createDate = createDate.substringBefore("T")
    }
}