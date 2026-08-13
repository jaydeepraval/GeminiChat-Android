package com.example.aidroidmentor.data

data class ChatMessage(
    val id: Long = System.currentTimeMillis(),

    val message: String,

    val isUser: Boolean,

    val time: String =
        java.text.SimpleDateFormat(
            "hh:mm a",
            java.util.Locale.getDefault()
        ).format(
            java.util.Date()
        )
)
