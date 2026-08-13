# Fix "Cannot create an instance of class ChatViewModel" error

The application crashes when trying to instantiate `ChatViewModel` because it's missing the `@HiltViewModel` annotation. Although it uses `@Inject constructor`, Hilt requires `@HiltViewModel` to properly integrate with `ViewModelProvider` and Compose's `hiltViewModel()`.

## Proposed Changes

### [Component Name] videmodels

#### [MODIFY] [ChatViewModel.kt](file:///D:/AndroidStudioProjects/AIDroidMentor/app/src/main/java/com/example/aidroidmentor/videmodels/ChatViewModel.kt)
- Add `@HiltViewModel` annotation to the `ChatViewModel` class.
- Add necessary import for `dagger.hilt.android.lifecycle.HiltViewModel`.

## Verification Plan

### Automated Tests
- I will run a build to ensure the Hilt processor correctly identifies the ViewModel.

### Manual Verification
- Deploy the app and navigate to the chat screen to verify that the `ChatViewModel` is correctly instantiated and the "Error was captured in composition" is resolved.
