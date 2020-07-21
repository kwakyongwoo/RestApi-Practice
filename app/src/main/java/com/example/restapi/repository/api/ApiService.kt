package com.example.restapi.repository.api

import com.example.restapi.repository.data.UserRepos
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("/repos/{owner}/{repos_name}")
    suspend fun getRepos(@Path("owner") owner: String, @Path("repos_name") name: String) : UserRepos

    @GET("/users/{owner}/repos")
    suspend fun getAllRepos(@Path("owner") owner: String) : List<UserRepos>
}