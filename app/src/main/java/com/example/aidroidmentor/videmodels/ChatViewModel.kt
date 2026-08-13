package com.example.aidroidmentor.videmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aidroidmentor.data.repository.ChatRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class ChatMessage(
    val text: String,
    val isUser: Boolean
)

data class ChatUiState(
    val messages: List<ChatMessage> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)

@HiltViewModel
class ChatViewModel @Inject constructor(
    private val repository: ChatRepository
) : ViewModel() {

    private val _uiState =
        MutableStateFlow(ChatUiState())

    val uiState: StateFlow<ChatUiState> =
        _uiState.asStateFlow()


    fun sendMessage(message: String) {

        if (message.isBlank()) {
            return
        }

        // Add user message
        _uiState.value =
            _uiState.value.copy(
                messages =
                    _uiState.value.messages +
                            ChatMessage(
                                text = message,
                                isUser = true
                            ),
                isLoading = true,
                error = null
            )

        viewModelScope.launch {

            val result =
                repository.sendMessage(message)

            result
                .onSuccess { answer ->

                    _uiState.value =
                        _uiState.value.copy(
                            messages =
                                _uiState.value.messages +
                                        ChatMessage(
                                            text = answer,
                                            isUser = false
                                        ),
                            isLoading = false
                        )
                }
                .onFailure { error ->

                    _uiState.value =
                        _uiState.value.copy(
                            isLoading = false,
                            error =
                                error.message
                                    ?: "Something went wrong"
                        )
                }
        }
    }

    fun clearChat() {

        _uiState.value =
            ChatUiState()
    }
}