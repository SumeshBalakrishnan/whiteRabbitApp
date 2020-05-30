package com.whiterabbit.test

import com.whiterabbit.test.network.ApiHelper

class MainRepository(private val apiHelper: ApiHelper) {
    suspend fun getUsers() = apiHelper.getUsers()
}