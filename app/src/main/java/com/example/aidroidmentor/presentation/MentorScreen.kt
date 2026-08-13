package com.example.aidroidmentor.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountTree
import androidx.compose.material.icons.filled.Android
import androidx.compose.material.icons.filled.Code
import androidx.compose.material.icons.filled.Cloud
import androidx.compose.material.icons.filled.DataObject
import androidx.compose.material.icons.filled.Fireplace
import androidx.compose.material.icons.filled.Storage
import androidx.compose.material.icons.filled.Sync
import androidx.compose.material.icons.filled.Widgets
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

data class MentorTopic(
    val title: String,
    val description: String,
    val icon: ImageVector
)

@Composable
fun MentorScreen(
    onTopicClick: (String) -> Unit
) {

    val topics = listOf(

        MentorTopic(
            title = "Kotlin",
            description = "Learn Kotlin for Android development",
            icon = Icons.Default.Code
        ),

        MentorTopic(
            title = "Jetpack Compose",
            description = "Build modern Android UI",
            icon = Icons.Default.Widgets
        ),

        MentorTopic(
            title = "Architecture",
            description = "MVVM, Clean Architecture and patterns",
            icon = Icons.Default.AccountTree
        ),

        MentorTopic(
            title = "Hilt & DI",
            description = "Dependency Injection with Hilt",
            icon = Icons.Default.DataObject
        ),

        MentorTopic(
            title = "Retrofit",
            description = "REST API integration",
            icon = Icons.Default.Cloud
        ),

        MentorTopic(
            title = "Room",
            description = "Local database with Room",
            icon = Icons.Default.Storage
        ),

        MentorTopic(
            title = "Coroutines & Flow",
            description = "Asynchronous programming",
            icon = Icons.Default.Sync
        ),

        MentorTopic(
            title = "Firebase",
            description = "Authentication, Firestore and more",
            icon = Icons.Default.Fireplace
        )
    )

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        item(
            span = {
                androidx.compose.foundation.lazy.grid.GridItemSpan(2)
            }
        ) {

            MentorHeader()
        }

        items(topics) { topic ->

            MentorTopicCard(
                topic = topic,
                onClick = {
                    onTopicClick(topic.title)
                }
            )
        }
    }
}

@Composable
private fun MentorHeader() {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp)
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            Icon(
                imageVector = Icons.Default.Android,
                contentDescription = "Android",
                modifier = Modifier.size(42.dp)
            )

            Spacer(
                modifier = Modifier.size(12.dp)
            )

            Text(
                text = "Android Mentor",
                style = MaterialTheme.typography.headlineMedium
            )
        }

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        Text(
            text = "Learn Android development with your AI mentor.",
            style = MaterialTheme.typography.bodyMedium
        )

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        Text(
            text = "Choose a topic to start learning",
            style = MaterialTheme.typography.titleMedium
        )
    }
}

@Composable
private fun MentorTopicCard(
    topic: MentorTopic,
    onClick: () -> Unit
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onClick()
            }
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {

            Icon(
                imageVector = topic.icon,
                contentDescription = topic.title,
                modifier = Modifier.size(34.dp)
            )

            Spacer(
                modifier = Modifier.height(12.dp)
            )

            Text(
                text = topic.title,
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(
                modifier = Modifier.height(6.dp)
            )

            Text(
                text = topic.description,
                style = MaterialTheme.typography.bodySmall
            )

            Spacer(
                modifier = Modifier.height(10.dp)
            )

            Text(
                text = "Start Learning →",
                style = MaterialTheme.typography.labelLarge
            )
        }
    }
}