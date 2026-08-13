import android.net.Uri
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Chat
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Chat
import androidx.compose.material.icons.filled.Quiz
import androidx.compose.material.icons.filled.School
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.aidroidmentor.domain.Screen
import com.example.aidroidmentor.presentation.InterviewScreen
import com.example.aidroidmentor.presentation.MentorScreen
import com.example.aidroidmentor.presentation.SavedDetailRoute
import com.example.aidroidmentor.ui.screen.ChatScreen
import com.example.aidroidmentor.ui.screen.SavedScreen

@Composable
fun AIChatNavigation() {

    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            NavigationBar {

                NavigationBarItem(
                    selected = false,
                    onClick = {
                        navController.navigate(Screen.Chat.route)
                    },
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Chat,
                            contentDescription = "Chat"
                        )
                    },
                    label = {
                        Text("Chat")
                    }
                )

                NavigationBarItem(
                    selected = false,
                    onClick = {
                        navController.navigate(Screen.Mentor.route)
                    },
                    icon = {
                        Icon(
                            imageVector = Icons.Default.School,
                            contentDescription = "Mentor"
                        )
                    },
                    label = {
                        Text("Mentor")
                    }
                )

                NavigationBarItem(
                    selected = false,
                    onClick = {
                        navController.navigate(Screen.Interview.route)
                    },
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Quiz,
                            contentDescription = "Interview"
                        )
                    },
                    label = {
                        Text("Interview")
                    }
                )

                NavigationBarItem(
                    selected = false,
                    onClick = {
                        navController.navigate(Screen.Saved.route) {
                            launchSingleTop = true
                        }
                    },
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Bookmark,
                            contentDescription = "Saved"
                        )
                    },
                    label = {
                        Text("Saved")
                    }
                )
            }
        }
    ) { paddingValues ->

        NavHost(
            navController = navController,
            startDestination = Screen.Chat.route,
            modifier = Modifier.padding(paddingValues)
        ) {

            composable(
                route = "${Screen.Chat.route}?topic={topic}",
                arguments = listOf(
                    navArgument("topic") {
                        type = NavType.StringType
                        defaultValue = ""
                    }
                )
            ) { backStackEntry ->

                val topic =
                    backStackEntry.arguments?.getString("topic")
                        ?: ""

                ChatScreen(
                    mentorTopic = topic
                )
            }

            composable(Screen.Mentor.route) {

                MentorScreen(
                    onTopicClick = { topic ->

                        navController.navigate(
                            "${Screen.Chat.route}?topic=${Uri.encode(topic)}"
                        )
                    }
                )
            }

            composable(Screen.Interview.route) {
                InterviewScreen(
                    onLevelSelected = { level ->
                        // Start interview
                    }
                )
            }

            composable(Screen.Saved.route) {

                SavedScreen(
                    onAnswerClick = { answerId ->

                        navController.navigate(
                            "saved_detail/$answerId"
                        )
                    }
                )
            }

            composable(
                route = "saved_detail/{answerId}"
            ) { backStackEntry ->

                val answerId =
                    backStackEntry.arguments
                        ?.getString("answerId")
                        ?.toLongOrNull()

                if (answerId != null) {

                    SavedDetailRoute(
                        answerId = answerId,
                        onBackClick = {
                            navController.popBackStack()
                        }
                    )
                }
            }
        }
    }
}