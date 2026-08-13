# 🤖 GeminiChat-Android

**GeminiChat-Android** is an AI-powered Android chat application built with **Kotlin and Jetpack Compose**, integrated with the **Google Gemini API** to provide an interactive AI chat experience.

The project demonstrates modern Android development practices including **MVVM architecture, Hilt Dependency Injection, Retrofit, Kotlin Coroutines & Flow, Room Database, and Jetpack Navigation Compose**.

---

## 📱 Features

* 🤖 AI-powered conversations using Google Gemini API
* 💬 Interactive chat interface
* 🧑‍🏫 AI Mentor-based learning experience
* 📚 Topic-based learning support
* 💾 Save and manage chat conversations
* 🗑️ Clear chat functionality
* 🎨 Modern Material UI using Jetpack Compose
* 🧭 Navigation using Navigation Compose
* 🔐 Secure API key configuration using `local.properties`
* 📱 Responsive UI for different screen sizes

---

## 🛠️ Tech Stack

| Technology             | Usage                        |
| ---------------------- | ---------------------------- |
| **Kotlin**             | Primary programming language |
| **Jetpack Compose**    | Modern Android UI            |
| **MVVM**               | Application architecture     |
| **Hilt**               | Dependency Injection         |
| **Retrofit**           | REST API integration         |
| **Kotlin Coroutines**  | Asynchronous programming     |
| **StateFlow / Flow**   | Reactive state management    |
| **Room Database**      | Local data persistence       |
| **Navigation Compose** | Screen navigation            |
| **Google Gemini API**  | AI-powered responses         |
| **Material 3**         | UI components                |

---

## 🏗️ Architecture

The application follows the **MVVM (Model-View-ViewModel)** architecture.

```text
UI Layer
   │
   ▼
Jetpack Compose Screens
   │
   ▼
ViewModel
   │
   ▼
Repository
   │
   ├── Gemini API
   │
   └── Room Database
```

### Main Components

* **UI** – Jetpack Compose screens and reusable components
* **ViewModel** – Manages UI state and business logic
* **Repository** – Handles data sources and API communication
* **Room** – Stores local chat data
* **Retrofit** – Handles network communication
* **Hilt** – Provides dependency injection

---

## 📂 Project Structure

```text
GeminiChat-Android/
│
├── app/
│   └── src/
│       └── main/
│           ├── java/
│           │   └── com.example.aidroidmentor/
│           │       ├── data/
│           │       ├── models/
│           │       ├── repository/
│           │       ├── viewmodel/
│           │       ├── ui/
│           │       └── navigation/
│           │
│           └── res/
│
├── gradle/
├── .gitignore
├── build.gradle.kts
├── gradle.properties
├── gradlew
├── gradlew.bat
└── settings.gradle.kts
```

---

## 🔑 Gemini API Configuration

The Gemini API key is **not included in this repository**.

Create a `local.properties` file in the project root:

```properties
GEMINI_API_KEY=YOUR_API_KEY
```

Make sure `local.properties` is included in `.gitignore` and **never commit your API key to GitHub**.

---

## 🚀 Getting Started

### 1. Clone the repository

```bash
git clone https://github.com/jaydeepraval/GeminiChat-Android.git
```

### 2. Open the project

Open the cloned project in **Android Studio**.

### 3. Configure the API key

Add your Gemini API key to:

```text
local.properties
```

Example:

```properties
GEMINI_API_KEY=YOUR_API_KEY
```

### 4. Sync the project

Allow Android Studio to complete Gradle synchronization.

### 5. Run the application

Connect an Android device or start an emulator and click **Run ▶**.

---

## 📸 Screenshots

Add application screenshots here to showcase the UI.

```text
screenshots/
├── splash.png
├── home.png
├── mentor.png
├── chat.png
└── saved_chats.png
```

---

## 🎯 Project Purpose

This project was developed to demonstrate practical experience in **modern Android application development** using Kotlin and Jetpack Compose.

It showcases:

* Modern Android UI development
* Clean architecture principles
* REST API integration
* AI integration
* Local database management
* Dependency Injection
* Reactive state management
* Navigation
* Secure configuration management

---

## 👨‍💻 Developer

**Jaydeep Raval**

Android Developer | Kotlin | Jetpack Compose | Java

---

## 📄 License

This project is intended for educational and portfolio purposes.
