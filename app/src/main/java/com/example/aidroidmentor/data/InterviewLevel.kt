package com.example.aidroidmentor.data

enum class InterviewLevel(
    val title: String,
    val description: String
) {
    BEGINNER(
        title = "Beginner",
        description = "Kotlin basics, Android fundamentals and Jetpack Compose"
    ),

    INTERMEDIATE(
        title = "Intermediate",
        description = "MVVM, Hilt, Retrofit, Room, Coroutines and Compose"
    ),

    SENIOR(
        title = "Senior",
        description = "Architecture, performance, system design and advanced Android"
    )
}