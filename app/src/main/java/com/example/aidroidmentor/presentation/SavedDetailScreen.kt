package com.example.aidroidmentor.presentation

import androidx.compose.material3.ExperimentalMaterial3Api


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.aidroidmentor.data.local.SavedAnswer

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SavedDetailScreen(
    answer: SavedAnswer,
    onBackClick: () -> Unit
) {

    Scaffold(

        topBar = {

            TopAppBar(

                title = {
                    Text("Saved Answer")
                },

                navigationIcon = {

                    IconButton(
                        onClick = onBackClick
                    ) {

                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                }
            )
        }

    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
                .verticalScroll(
                    rememberScrollState()
                ),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            Row(
                modifier = Modifier.fillMaxWidth()
            ) {

                Icon(
                    imageVector = Icons.Default.Bookmark,
                    contentDescription = "Saved"
                )

                Spacer(
                    modifier = Modifier.padding(horizontal = 6.dp)
                )

                Text(
                    text = answer.category,
                    style = MaterialTheme.typography.labelLarge
                )
            }

            Text(
                text = answer.title,
                style = MaterialTheme.typography.headlineSmall
            )

            Spacer(
                modifier = Modifier.height(12.dp)
            )

            Text(
                text = "Question",
                style = MaterialTheme.typography.titleMedium
            )

            Text(
                text = answer.question,
                style = MaterialTheme.typography.bodyLarge
            )

            Spacer(
                modifier = Modifier.height(16.dp)
            )

            Text(
                text = "AI Answer",
                style = MaterialTheme.typography.titleMedium
            )

            Text(
                text = answer.answer,
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}