package com.example.aidroidmentor.di

import com.example.aidroidmentor.data.InterviewLevel
import com.example.aidroidmentor.data.InterviewQuestion


object InterviewQuestions {

    val questions = listOf(

        // Beginner
        InterviewQuestion(
            question = "What is Kotlin and why is it preferred for Android development?",
            level = InterviewLevel.BEGINNER
        ),

        InterviewQuestion(
            question = "What is the difference between val and var in Kotlin?",
            level = InterviewLevel.BEGINNER
        ),

        InterviewQuestion(
            question = "What is a Composable function in Jetpack Compose?",
            level = InterviewLevel.BEGINNER
        ),

        InterviewQuestion(
            question = "What is the Activity lifecycle in Android?",
            level = InterviewLevel.BEGINNER
        ),

        InterviewQuestion(
            question = "What is the difference between remember and rememberSaveable?",
            level = InterviewLevel.BEGINNER
        ),

        // Intermediate
        InterviewQuestion(
            question = "Explain MVVM architecture in Android.",
            level = InterviewLevel.INTERMEDIATE
        ),

        InterviewQuestion(
            question = "What is Dependency Injection and how does Hilt implement it?",
            level = InterviewLevel.INTERMEDIATE
        ),

        InterviewQuestion(
            question = "What is Kotlin Coroutines and why are they useful in Android?",
            level = InterviewLevel.INTERMEDIATE
        ),

        InterviewQuestion(
            question = "What is Retrofit and how do you handle API calls?",
            level = InterviewLevel.INTERMEDIATE
        ),

        InterviewQuestion(
            question = "What is StateFlow and how is it used in Jetpack Compose?",
            level = InterviewLevel.INTERMEDIATE
        ),

        // Senior
        InterviewQuestion(
            question = "How would you design a scalable Android application architecture?",
            level = InterviewLevel.SENIOR
        ),

        InterviewQuestion(
            question = "How would you optimize an Android application for performance?",
            level = InterviewLevel.SENIOR
        ),

        InterviewQuestion(
            question = "How would you handle offline-first data synchronization?",
            level = InterviewLevel.SENIOR
        ),

        InterviewQuestion(
            question = "Explain how you would design a real-time chat application for Android.",
            level = InterviewLevel.SENIOR
        ),

        InterviewQuestion(
            question = "How would you prevent memory leaks in an Android application?",
            level = InterviewLevel.SENIOR
        )
    )
}