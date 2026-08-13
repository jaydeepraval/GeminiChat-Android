package com.example.aidroidmentor.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onNewChatClick: () -> Unit,
    onSettingsClick: () -> Unit
) {

    Scaffold(

        topBar = {

            TopAppBar(
                title = {
                    Text("AI Assistant")
                }
            )

        }

    ) { padding ->


        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {


            Button(
                onClick = {
                    onNewChatClick()
                }
            ) {

                Text("New Chat")

            }


            Spacer(
                modifier = Modifier.height(20.dp)
            )


            OutlinedButton(
                onClick = {
                    onSettingsClick()
                }
            ) {

                Text("Settings")

            }

        }

    }

}