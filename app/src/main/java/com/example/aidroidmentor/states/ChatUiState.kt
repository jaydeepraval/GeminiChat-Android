package com.example.aidroidmentor.states

import com.example.aidroidmentor.data.ChatMessage

data class ChatUiState(
    val message: List<ChatMessage> = emptyList(),
    val isLoading : Boolean = false,
    val error: String? = null,
    val isTyping: Boolean = false
)
