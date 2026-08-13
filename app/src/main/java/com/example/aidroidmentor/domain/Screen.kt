package com.example.aidroidmentor.domain

sealed class Screen(
    val route: String,
    val title: String
) {
    data object Chat : Screen("chat", "Chat")
    data object Mentor : Screen("mentor", "Mentor")
    data object Interview : Screen("interview", "Interview")
    data object Saved : Screen("saved", "Saved")
}