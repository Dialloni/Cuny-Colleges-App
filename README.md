# CUNY Map App

An Android application that helps users locate and explore CUNY (City University of New York) colleges on an interactive map.

## Features

- **College List**: Browse through a comprehensive list of CUNY colleges including:
  - BMCC (Borough of Manhattan Community College)
  - Baruch College
  - Hunter College
  - City College
  - Lehman College
  - John Jay College
  - Queens College
  - Brooklyn College

- **Interactive Map**:
  - Search for any address or location
  - View locations on Google Maps
  - Get precise coordinates and directions
  - Zoom and navigate the map interface

- **Fragment-based Navigation**:
  - Seamless switching between college list and map views
  - Clean, modern Android UI design

## Technical Stack

- **Language**: Kotlin
- **Platform**: Android (API 24+)
- **Architecture**: Fragment-based navigation
- **Maps**: Google Maps Android API
- **UI**: View Binding, Material Design Components
- **Location Services**: Android Location APIs with Geocoder

## Prerequisites

- Android Studio Arctic Fox or later
- Android SDK with API level 24 or higher
- Google Maps API Key
- Device or emulator with Google Play Services

## Setup Instructions

1. **Clone the repository**

   ```bash
   git clone <your-repository-url>
   cd cunyMapApp
   ```

2. **Get Google Maps API Key**
   - Go to the [Google Cloud Console](https://console.cloud.google.com/)
   - Create a new project or select an existing one
   - Enable the Maps SDK for Android
   - Create credentials (API Key)
   - Restrict the API key to your app's package name

3. **Configure API Key**
   - Open `app/src/main/AndroidManifest.xml`
   - Replace the existing API key with your own:

   ```xml
   <meta-data
       android:name="com.google.android.geo.API_KEY"
       android:value="YOUR_API_KEY_HERE" />
   ```

4. **Build and Run**
   - Open the project in Android Studio
   - Sync the project with Gradle files
   - Run the app on your device or emulator

## Project Structure

```text
app/
├── src/main/
│   ├── java/com/example/cunymapapp/
│   │   ├── MainActivity.kt          # Main activity with navigation
│   │   ├── CollegeListFragment.kt   # Fragment displaying CUNY colleges
│   │   └── MapFragment.kt           # Fragment with Google Maps integration
│   ├── res/
│   │   ├── layout/                  # XML layout files
│   │   ├── values/                  # App resources (strings, colors, themes)
│   │   └── xml/                     # Configuration files
│   └── AndroidManifest.xml          # App configuration and permissions
├── build.gradle.kts                 # App-level build configuration
└── proguard-rules.pro              # ProGuard configuration
```

## Permissions

The app requires the following permissions:

- `INTERNET`: For loading map tiles and geocoding
- `ACCESS_FINE_LOCATION`: For precise location services
- `ACCESS_COARSE_LOCATION`: For approximate location services

## Dependencies

- **Google Play Services Maps**: `18.2.0`
- **AndroidX Core KTX**: `1.12.0`
- **AppCompat**: `1.6.1`
- **Material Design**: `1.9.0`
- **ConstraintLayout**: `2.1.4`

## How to Use

1. **Launch the app** - The app starts with the college list view
2. **Browse colleges** - Scroll through the list of CUNY colleges
3. **Search location** - Enter an address in the text field
4. **View on map** - Tap the "Show Map" button to see the location on Google Maps
5. **Navigate** - Use standard map gestures to zoom and pan

## Development Notes

- The app uses View Binding for type-safe view references
- Fragments are used for modular UI components
- The Geocoder service converts addresses to coordinates
- Google Maps integration follows Android best practices

## Build Configuration

- **Compile SDK**: 35
- **Min SDK**: 24 (Android 7.0)
- **Target SDK**: 35
- **Version**: 1.0 (Version Code: 1)

## Testing

The project includes:

- Unit tests in `src/test/`
- Instrumented tests in `src/androidTest/`

Run tests using:

```bash
./gradlew test
./gradlew connectedAndroidTest
```

## Contributing

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Add tests if applicable
5. Submit a pull request

## License

This project is open source and available under the [MIT License](LICENSE).

## Support

For questions or issues, please open an issue in the repository or contact the development team.

---

**Note**: Remember to keep your Google Maps API key secure and never commit it to public repositories. Consider using environment variables or Android's BuildConfig for production applications.
