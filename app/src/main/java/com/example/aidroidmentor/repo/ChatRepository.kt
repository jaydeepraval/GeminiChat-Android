package com.example.aidroidmentor.data.repository

import com.example.aidroidmentor.BuildConfig
import com.example.aidroidmentor.data.GeminiContent
import com.example.aidroidmentor.data.GeminiPart
import com.example.aidroidmentor.data.GeminiRequest
import com.example.aidroidmentor.data.remote.GeminiApi
import retrofit2.HttpException
import javax.inject.Inject

class ChatRepository @Inject constructor(
    private val geminiApi: GeminiApi
) {

    suspend fun sendMessage(
        message: String
    ): Result<String> {

        return try {

            val request = GeminiRequest(
                contents = listOf(
                    GeminiContent(
                        role = "user",
                        parts = listOf(
                            GeminiPart(
                                text = message
                            )
                        )
                    )
                )
            )

            val response = geminiApi.generateContent(
                apiKey = BuildConfig.GEMINI_API_KEY,
                request = request
            )

            val answer = response
                .candidates
                ?.firstOrNull()
                ?.content
                ?.parts
                ?.firstOrNull()
                ?.text

            if (!answer.isNullOrBlank()) {
                Result.success(answer)
            } else {
                Result.failure(
                    Exception("Gemini returned empty response")
                )
            }

        } catch (e: HttpException) {

            val errorBody = e.response()?.errorBody()?.string()

            Result.failure(
                Exception(
                    "HTTP ${e.code()}\n$errorBody"
                )
            )

        } catch (e: Exception) {

            Result.failure(
                Exception(
                    e.message ?: "Unknown error"
                )
            )
        }
    }
}