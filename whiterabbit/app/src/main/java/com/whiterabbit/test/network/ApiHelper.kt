package com.whiterabbit.test.network

class ApiHelper(private val apiService: ApiService) {

    suspend fun getUsers() = apiService.getUsers()
}