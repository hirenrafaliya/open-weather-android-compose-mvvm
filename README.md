# Open Weather

An android weather app developed using Jetpack compose and uses [weatherapi.com](https://www.weatherapi.com/) for weather data.

## Features
- Current user location to fetch the weather data
- Search for any locations
- Detailed view of weather informations like humidity, wind speed, average/min/max temprature, rain/snow predictions, etc.
- Forecast for upcoming week

## How to setup
- Just replace the "YOUR-API-KEY-HERE" with your [weatherapi.com](https://www.weatherapi.com/) api key inside [/data/cpp/libnative-lib.cpp](https://github.com/hirenrafaliya/open-weather-android-compose-mvvm/blob/0a1fdb36a501d1222771219158be4513ebff80de/data/cpp/libnative-lib.cpp)
- Open project in Android Studio. Good to Go!

## Architecture
- App uses MVVM [multi-module](https://developer.android.com/topic/modularization) architecture consists of 3 core modules and multiple sub-modules or [layers](https://developer.android.com/topic/architecture).
1. [Data](https://developer.android.com/topic/architecture/data-layer) - Manages remote & local database and connections
2. [Domain](https://developer.android.com/topic/architecture/domain-layer) - Encapsulates complex logics to simple logics for UI
3. [Presentation/UI](https://developer.android.com/topic/architecture/ui-layer) - Renders UI on screens

## Libraries
- Jetpack compose - Modern UI toolkit 
- Hilt - Dependency injection
- Ktor - Manage remote connection with server & client
- Coil - Asynchronus image loading
- Kotlin Serialization - Parse JSON data from networks

## Screenshot
<p float="left">
  <img src="https://github.com/hirenrafaliya/open-weather-android-compose-mvvm/blob/dev/assets/Screenshot_20240506_022727.png?raw=true" width="200" />
  <img src="https://github.com/hirenrafaliya/open-weather-android-compose-mvvm/blob/dev/assets/Screenshot_20240506_022855.png?raw=true" width="200" /> 
  <img src="https://github.com/hirenrafaliya/open-weather-android-compose-mvvm/blob/dev/assets/Screenshot_20240506_022917.png?raw=true" width="200" />
  <img src="https://github.com/hirenrafaliya/open-weather-android-compose-mvvm/blob/dev/assets/Screenshot_20240506_022929.png?raw=true" width="200" />
  <img src="https://github.com/hirenrafaliya/open-weather-android-compose-mvvm/blob/dev/assets/Screenshot_20240506_022942.png?raw=true" width="200" />
  <img src="https://github.com/hirenrafaliya/open-weather-android-compose-mvvm/blob/dev/assets/Screenshot_20240506_023011.png?raw=true" width="200" />
  <img src="https://github.com/hirenrafaliya/open-weather-android-compose-mvvm/blob/dev/assets/Screenshot_20240506_023227.png?raw=true" width="200" />
</p>
