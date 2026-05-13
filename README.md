# Holiday Trip — Android Mobile Application

## Bachelor's Final Year Project — CET343 Android Mobile Development

**BSc (Hons) Computer Systems Engineering**
**University of Sunderland (UK), delivered at ISMT College, Kathmandu, Nepal**
**Academic Year 2022/23**

**Student**: Govinda Bist
**Student ID**: 220075996
**Final Mark**: 63 (Pass)

---

## Overview

**Holiday Trip** is a native Android mobile application that enables users to plan, organize, and manage their travel plans in one place. The application supports user authentication and full CRUD (Create, Read, Update, Delete) operations on travel plans, with data persisted to a cloud-based Firebase Realtime Database for cross-device accessibility.

The project addresses a common challenge for travelers: keeping track of expenses, locations, and important details for trips, both to reflect on past travels and to share useful information with friends or family planning similar journeys.

## Features

- **User Authentication** — Email/password registration and login powered by Firebase Authentication
- **Add Travel Plans** — Create new travel plans with name, location, price, and description
- **View & Manage Plans** — Browse saved plans from the home screen
- **Edit Plans** — Update any field of an existing travel plan
- **Delete Plans** — Remove plans no longer needed
- **Cloud Synchronization** — All data stored in Firebase Realtime Database, accessible across devices
- **Session Persistence** — Automatic login on app restart for authenticated users
- **Material 3 Design** — Modern UI following Google's Material Design 3 guidelines

## Technologies Used

| Layer | Technology |
|---|---|
| **Platform** | Android (Native) |
| **Programming Language** | Java |
| **Minimum SDK** | API 24 (Android 7.0 Nougat) |
| **Target SDK** | API 33 (Android 13) |
| **IDE** | Android Studio |
| **Build System** | Gradle (Kotlin DSL) |
| **Authentication** | Firebase Authentication |
| **Database** | Firebase Realtime Database (cloud) |
| **UI Framework** | AndroidX with Material Components 3 |
| **Theme** | Material 3 Light |
| **Layout System** | ConstraintLayout |
| **Data Passing** | Parcelable interface for inter-Activity data transfer |

## Architecture

The application follows a standard Activity-based Android architecture with the following components:

### Activities

| Activity | Purpose |
|---|---|
| `Login.java` | Email/password login screen, entry point of the app |
| `Register.java` | New user registration with email/password validation |
| `MainActivity.java` | Home screen displaying user info and logout option |
| `AddPlan.java` | Form to create a new travel plan |
| `EditPlan.java` | Form to edit or delete an existing travel plan |

### Model

| Class | Purpose |
|---|---|
| `PlanRVModal.java` | Plan data model implementing Parcelable, fields: planName, planPrice, planDesc, planLocation, planID |

## Project Structure

HolidayTrip/
├── app/
│   ├── src/main/
│   │   ├── java/com/example/holidaytrip/
│   │   │   ├── MainActivity.java       # Home screen
│   │   │   ├── Login.java              # Login screen
│   │   │   ├── Register.java           # Registration screen
│   │   │   ├── AddPlan.java            # Add new plan
│   │   │   ├── EditPlan.java           # Edit/delete plan
│   │   │   └── PlanRVModal.java        # Plan data model
│   │   ├── res/
│   │   │   ├── layout/                 # XML UI layouts (5 activities)
│   │   │   ├── values/                 # Strings, colors, themes
│   │   │   └── drawable/               # Vector assets
│   │   └── AndroidManifest.xml         # App configuration & permissions
│   └── build.gradle.kts                # App-level Gradle config
├── build.gradle.kts                    # Project-level Gradle config
├── settings.gradle.kts
└── gradle/                             # Gradle wrapper


## Permissions Used

- `INTERNET` — Required for Firebase communication
- `ACCESS_NETWORK_STATE` — Required for network status checks

## Key Implementation Highlights

- **Authentication flow** — `MainActivity` checks `FirebaseAuth.getCurrentUser()` on launch and redirects to login if no user is authenticated
- **Real-time database integration** — Uses `ValueEventListener` to read from and write to Firebase Realtime Database under the "Plans" node
- **CRUD operations** — Demonstrates create (AddPlan), read (data retrieval), update (EditPlan with HashMap-based field updates), and delete (using `removeValue()`)
- **Parcelable data passing** — Travel plan data is serialized via `Parcelable` to pass between `MainActivity` and `EditPlan`
- **Input validation** — Empty field checks on login with user-friendly Toast messages
- **Progress feedback** — Progress bars during network operations for better UX

## Academic Context

This project was developed as the final-year capstone project for the **CET343 Android Mobile Development** module, part of the **BSc (Hons) Computer Systems Engineering** degree awarded by the **University of Sunderland (UK)** and delivered at **ISMT College, Kathmandu, Nepal**.

The project deliverables included:
- A fully working Android application
- A comprehensive academic report covering analysis (native vs. cross-platform mobile development, OS comparison, storage design, security considerations), design (screen hierarchy, wireframes), implementation, testing, and evaluation
- Documentation of design decisions and trade-offs

### Skills Demonstrated

- Native Android application development with Java
- Firebase Authentication and Realtime Database integration
- Multi-Activity navigation and inter-Activity data passing using Parcelable
- Material Design 3 UI implementation
- CRUD operations on a cloud-based database
- Gradle build configuration (Kotlin DSL)
- Academic technical writing and project documentation

## Setting Up the Project Locally

This repository **does not include** `google-services.json` for security reasons. To run this project:

1. Clone the repository
2. Create a Firebase project at [console.firebase.google.com](https://console.firebase.google.com/)
3. Add an Android app to the Firebase project with package name `com.example.holidaytrip`
4. Enable **Authentication** (Email/Password) and **Realtime Database** in the Firebase Console
5. Download `google-services.json` from your Firebase project
6. Place `google-services.json` in the `app/` directory
7. Open the project in Android Studio
8. Sync Gradle and run on an emulator or device (API 24+)

## Repository Contents

- `app/` — Android application source code
- `gradle/`, `build.gradle.kts`, `settings.gradle.kts` — Build configuration
- `Holiday_Trip_Project_Report.pdf` — Full academic project report
- `README.md` — This file

## Author

**Govinda Bist**
- BSc (Hons) Computer Systems Engineering — University of Sunderland (UK), 2023
- Based in Kathmandu, Nepal
- GitHub: [your username]

## License

This project was developed for academic purposes as part of an undergraduate degree programme. It is provided as a portfolio piece for graduate school applications.
