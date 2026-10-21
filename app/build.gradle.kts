plugins {
    id("com.android.application")
}

android {
    namespace = "com.adrnhvis.mvvm"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.adrnhvis.mvvm"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    // --- Dependensi UI & MVVM Dasar (dari materi sebelumnya) ---
    implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")
    implementation("androidx.appcompat:appcompat:1.7.1")
    implementation("com.google.android.material:material:1.13.0")
    implementation("androidx.constraintlayout:constraintlayout:2.2.1")

    // --- Dependensi Baru untuk REST API ---
    // Retrofit utama untuk melakukan request HTTP
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    // Gson Converter untuk mengubah data JSON dari Laravel menjadi objek Java
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    // (Dependensi testing bawaan seperti junit dan espresso bisa dibiarkan)
}