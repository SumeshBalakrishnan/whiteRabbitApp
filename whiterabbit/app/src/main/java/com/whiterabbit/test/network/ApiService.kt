package com.whiterabbit.test.network

import com.whiterabbit.test.model.Response
import retrofit2.http.GET

interface ApiService {
    @GET("v2/5d565297300000680030a986")
    suspend fun getUsers(): List<Response>
}