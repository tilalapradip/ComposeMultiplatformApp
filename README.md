

Project Details
1. This is a Compose Multiplatform project targeting Android, iOS.
2. This App lists the Mobile Products using free API. [/objects](https://api.restful-api.dev/objects)
3. `/composeApp` is for code that will be shared across your Compose Multiplatform applications.
   It contains several subfolders:
   - `commonMain` is for code that’s common for all targets.
   - Other folders are for Kotlin code that will be compiled for only the platform indicated in the folder name.
   - For example, if you want to use Apple’s CoreCrypto for the iOS part of your Kotlin app, `iosMain` would be the right folder for such calls.
4. `/iosApp` contains iOS applications. Even if you’re sharing your UI with Compose Multiplatform, you need this entry point for your iOS app. This is also where you should add SwiftUI code for your project.
5. MVVM architecture with [ViewModel, Experimental in Compose Multiplatform](https://www.jetbrains.com/help/kotlin-multiplatform-dev/compose-viewmodel.html)
6. API: [Mobile List](https://api.restful-api.dev/objects) to get list of Mobiles.
7. Uses Ktor Client & Json Format for content negoatiation.
8. All required extra dependencies for Ktor Client & Viewmodel are defined in catalog file `libs.versions.toml`
9. Dependencies for KTor Client negotiations are in commonMain.dependencies{ } block of `gradle(composeApp)` file.
```kotlin
   implementation(libs.ktor.client.core)
   implementation(libs.ktor.client.content.negotiation)
   implementation(libs.ktor.serialization.kotlinx.json)
```
11. Dependency for ViewModel is in commonMain.dependencies{ } block of `gradle(composeApp)` file. [ViewModel](https://www.jetbrains.com/help/kotlin-multiplatform-dev/compose-viewmodel.html)
```kotlin
    implementation(libs.lifecycle.viewmodel.compose)
```
12. This app has setup for fake API(using method ```fun getMobilesFake(){ }```) in Viewmodel class after given API limit is reached.


Learn more about [Kotlin Multiplatform](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html)…
