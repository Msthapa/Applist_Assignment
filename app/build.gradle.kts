plugins {
    id("kotlin-kapt")
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.dagger.hilt)
    alias(libs.plugins.androidx.nav.safeargs)
}

android {
    namespace = "com.example.applist"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.applist"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildFeatures {
        dataBinding = true
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)

    //hilt-dependency-injection
    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)

    //room database
    implementation(libs.androidx.room.runtime)
    implementation(libs.androidx.room.ktx)
    kapt(libs.androidx.room.compiler)

    //retrofit
    implementation(libs.squareup.retrofit)
    implementation(libs.squareup.converter.gson)

    //Glide
    implementation(libs.bumptech.glide)
    kapt(libs.bumptech.glide.compiler)

    //fragment/activity ktx
    implementation(libs.activity.ktx)
    implementation(libs.fragment.ktx)

    //navigation
    implementation(libs.androidx.nav.fragment)
    implementation(libs.androidx.nav.ui)

    //pull to refresh
    implementation(libs.androidx.swiperefreshlayout)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}