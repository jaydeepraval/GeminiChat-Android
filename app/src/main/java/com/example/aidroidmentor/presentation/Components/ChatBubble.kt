import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.ContentCopy
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.aidroidmentor.videmodels.ChatMessage

@Composable
fun ChatBubble(
    message: ChatMessage,
    onSave: () -> Unit
) {

    Column {

        Text(
            text = message.text
        )

        Row {

            IconButton(
                onClick = onSave
            ) {
                Icon(
                    imageVector = Icons.Default.Bookmark,
                    contentDescription = "Save"
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