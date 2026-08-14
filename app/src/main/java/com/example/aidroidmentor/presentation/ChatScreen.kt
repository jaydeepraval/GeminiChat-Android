package com.example.aidroidmentor.ui.screen

import com.example.aidroidmentor.presentation.components.ChatBubble
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.aidroidmentor.videmodels.ChatViewModel
import com.example.aidroidmentor.videmodels.SavedViewModel

@Composable
fun ChatScreen(
    mentorTopic: String = "",
    viewModel: ChatViewModel = hiltViewModel(),
    savedViewModel: SavedViewModel = hiltViewModel()
) {

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    var message by remember {
        mutableStateOf("")
    }

    val listState = rememberLazyListState()

    /*
     * Automatically scroll to latest message
     */
    LaunchedEffect(mentorTopic) {

        if (mentorTopic.isNotBlank()) {

            val prompt = """
                You are an expert Android development mentor.

                Teach me $mentorTopic for Android development.

                Please explain:

                1. What is $mentorTopic?
                2. Why is it used in Android?
                3. Explain it in simple language.
                4. Give a real Android example.
                5. Show Kotlin code.
                6. Explain common mistakes.
                7. Give interview questions.
                8. Give me a small practice task.

                Start teaching me step by step.
            """.trimIndent()

            viewModel.sendMessage(prompt)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {

        /*
         * Chat messages
         */
        if (uiState.error != null) {

            Text(
                text = uiState.error!!,
                color = MaterialTheme.colorScheme.error,
                modifier = Modifier.padding(16.dp)
            )
        }
        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            state = listState,
            contentPadding = androidx.compose.foundation.layout.PaddingValues(
                16.dp
            ),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            items(
                items = uiState.messages
            ) { chatMessage ->

                ChatBubble(
                    message = chatMessage,
                    onSave = {

                        if (!chatMessage.isUser) {

                            savedViewModel.saveAnswer(
                                title = "AI Answer",
                                question = "Android Question",
                                answer = chatMessage.text,
                                category = "AI Chat"
                            )
                        }
                    }
                )
            }
        }

        /*
         * Loading indicator
         */
        if (uiState.isLoading) {

            Text(
                text = "AI is thinking...",
                modifier = Modifier.padding(
                    horizontal = 16.dp,
                    vertical = 8.dp
                ),
                style = MaterialTheme.typography.bodyMedium
            )
        }

        /*
         * Message input
         */
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            OutlinedTextField(
                value = message,
                onValueChange = {
                    message = it
                },
                modifier = Modifier.weight(1f),
                placeholder = {
                    Text("Ask your AI mentor...")
                },
                maxLines = 4
            )

            Spacer(
                modifier = Modifier.width(8.dp)
            )

            /*IconButton(
                onClick = {

                    if (message.isNotBlank()) {

                        viewModel.sendMessage(
                            message.trim()
                        )

                        message = ""
                    }
                }
            ) {

                Icon(
                    imageVector = Icons.Default.Send,
                    contentDescription = "Send"
                )
            }*/

            IconButton(
                onClick = {

                    val text = message.trim()

                    if (text.isNotEmpty() && !uiState.isLoading) {

                        viewModel.sendMessage(text)

                        message = ""
                    }
                }
            ) {

                Icon(
                    imageVector = Icons.Default.Send,
                    contentDescription = "Send"
                )
            }
        }
    }
}