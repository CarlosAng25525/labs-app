# Fix Warnings and Errors in `app/build.gradle.kts`

The goal is to resolve the unresolved references (`kotlinOptions`, `jvmTarget`), update outdated SDK versions, and migrate hardcoded dependencies to the version catalog (`libs.versions.toml`) while also updating them to the latest stable versions.

## Proposed Changes

### Build Configuration

#### [MODIFY] [libs.versions.toml](file:///C:/Users/USUARIO/AndroidStudioProjects/MyApplication/gradle/libs.versions.toml)
- Update versions to the latest stable ones:
    - `coreKtx` -> `1.19.0`
    - `lifecycleRuntimeKtx` -> `2.11.0`
    - `activityCompose` -> `1.13.0`
    - `composeBom` -> `2026.08.00`
- Add `kotlin-android` plugin definition.
- Ensure `kotlin` version is consistent (currently `2.2.10` in TOML, but root build file shows `1.9.23`).

#### [MODIFY] [root build.gradle.kts](file:///C:/Users/USUARIO/AndroidStudioProjects/MyApplication/build.gradle.kts)
- Update `agp` and `kotlin` versions to match `libs.versions.toml` or migrate to the `plugins` block to avoid duplication.

#### [MODIFY] [app build.gradle.kts](file:///C:/Users/USUARIO/AndroidStudioProjects/MyApplication/app/build.gradle.kts)
- Update `compileSdk` and `targetSdk` to 37.
- Use `alias` for plugins from the version catalog.
- Replace hardcoded dependencies with `libs` references.
- Remove `composeOptions` as the project will use the Kotlin Compose plugin (Kotlin 2.0+).
- Fix `kotlinOptions` unresolved reference by ensuring the plugin is correctly applied via `alias`.

## Verification Plan

### Automated Tests
- Run `./gradlew assembleDebug` to ensure the project builds successfully.
- Run `analyze_file` again to verify all warnings and errors are gone.

### Manual Verification
- Sync the project in Android Studio to ensure the IDE recognizes all references.
