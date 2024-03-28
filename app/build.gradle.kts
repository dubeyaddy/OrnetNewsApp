plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {
    namespace = "com.ornet.newsapp"
    compileSdk = 34

    defaultConfig {
        multiDexEnabled = true
        applicationId = "com.ornet.newsapp"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
//        buildConfigField("String", "API_KEY", "\"5a3e054de1834138a2fbc4a75ee69053\"")
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        buildConfig = true
        viewBinding = true
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    coreLibraryDesugaring ("com.android.tools:desugar_jdk_libs:1.1.5")

    implementation ("androidx.viewpager2:viewpager2:1.0.0")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.5.1")
    implementation ("androidx.activity:activity-ktx:1.6.0")
    implementation ("androidx.core:core-ktx:1.9.0")
    implementation ("androidx.legacy:legacy-support-v4:1.0.0")

    implementation ("androidx.room:room-runtime:2.4.3")
    kapt ("androidx.room:room-compiler:2.4.3")

    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.0")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")

    implementation ("com.squareup.picasso:picasso:2.71828")

    implementation ("com.facebook.shimmer:shimmer:0.5.0")

//    implementation ("'com.github.jama5262:CarouselView:1.2.2'")
//    implementation ("com.synnapps:carouselview:0.1.4")
}