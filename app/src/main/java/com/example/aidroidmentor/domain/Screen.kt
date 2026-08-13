package com.example.aidroidmentor.domain

sealed class Screen(
    val route: String
) {

    data object Splash :
        Screen("splash")

    data object Mentor :
        Screen("mentor")

    data object Chat :
        Screen("chat")

    data object Interview :
        Screen("interview")

    data object Saved :
        Screen("saved")
}