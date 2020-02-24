package com.example.restapi.repository

import com.example.restapi.repository.api.ApiService

class UserRepository {

    var client: ApiService = RetrofitClient.webService

    suspend fun getRepos(owner: String, name: String) = client.getRepos(owner, name)

    suspend fun getAllRepos(owner: String) = client.getAllRepos(owner)
}