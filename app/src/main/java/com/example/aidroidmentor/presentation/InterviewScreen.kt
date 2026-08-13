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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Code
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.WorkspacePremium
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.example.aidroidmentor.data.InterviewLevel


@Composable
fun InterviewScreen(
    onLevelSelected: (String) -> Unit
) {

    val levels = listOf(
        InterviewLevel(
            title = "Beginner",
            description = "Kotlin basics, Android fundamentals and UI",
            icon = Icons.Default.Code
        ),
        InterviewLevel(
            title = "Intermediate",
            description = "Architecture, Compose, Hilt, Retrofit and Room",
            icon = Icons.Default.Code
        ),
        InterviewLevel(
            title = "Senior",
            description = "Advanced Android, performance and system design",
            icon = Icons.Default.WorkspacePremium
        )
    )

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        item {

            Text(
                text = "Android Interview Prep",
                style = MaterialTheme.typography.headlineMedium
            )

            Spacer(
                modifier = Modifier.height(8.dp)
            )

            Text(
                text = "Practice Android interview questions with your AI mentor.",
                style = MaterialTheme.typography.bodyMedium
            )

            Spacer(
                modifier = Modifier.height(24.dp)
            )

            Text(
                text = "Select your experience level",
                style = MaterialTheme.typography.titleLarge
            )
        }

        items(levels.size) { index ->

            val level = levels[index]

            InterviewLevelCard(
                level = level,
                onClick = {
                    onLevelSelected(level.title)
                }
            )
        }
    }
}

@Composable
private fun InterviewLevelCard(
    level: InterviewLevel,
    onClick: () -> Unit
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onClick()
            },
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        )
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Icon(
                imageVector = level.icon,
                contentDescription = level.title,
                modifier = Modifier.size(42.dp)
            )

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 16.dp)
            ) {

                Text(
                    text = level.title,
                    style = MaterialTheme.typography.titleLarge
                )

                Spacer(
                    modifier = Modifier.height(4.dp)
                )

                Text(
                    text = level.description,
                    style = MaterialTheme.typography.bodyMedium
                )
            }

            Icon(
                imageVector = Icons.Default.KeyboardArrowRight,
                contentDescription = "Select"
            )
        }
    }
}