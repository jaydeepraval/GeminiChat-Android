package com.example.aidroidmentor.presentation.components
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.ContentCopy
import androidx.compose.material.icons.outlined.BookmarkBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import com.example.aidroidmentor.videmodels.ChatMessage

@Composable
fun ChatBubble(
    message: ChatMessage,
    onSave: () -> Unit
) {

    var isSaved by rememberSaveable {
        mutableStateOf(false)
    }

    Column {

        Text(
            text = message.text
        )

        Row {

            IconButton(
                onClick = {
                    isSaved = !isSaved
                    onSave()
                }
            ) {
                Icon(
                    imageVector = if (isSaved) {
                        Icons.Default.Bookmark
                    } else {
                        Icons.Outlined.BookmarkBorder
                    },
                    contentDescription = if (isSaved) {
                        "Unsave"
                    } else {
                        "Save"
                    }
                )
            }

            IconButton(
                onClick = {
                    // Copy
                }
            ) {
                Icon(
                    imageVector = Icons.Default.ContentCopy,
                    contentDescription = "Copy"
                )
            }
        }
    }
}