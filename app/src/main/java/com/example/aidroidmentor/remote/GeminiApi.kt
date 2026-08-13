package com.example.aidroidmentor.data.remote

import com.example.aidroidmentor.data.GeminiRequest
import com.example.aidroidmentor.data.GeminiResponse
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface GeminiApi {

    @POST("v1beta/models/gemini-3.6-flash:generateContent")
    suspend fun generateContent(
        @Header("x-goog-api-key") apiKey: String,
        @Body request: GeminiRequest
    ): GeminiResponse
}