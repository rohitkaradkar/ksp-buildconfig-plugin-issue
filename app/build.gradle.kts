plugins {
    alias(libs.plugins.sampleapp.android.application)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.sampleapp.android.hilt)
}

android {
    namespace = "com.example.kspbuildconfigissue"

    defaultConfig {
        applicationId = "com.example.kspbuildconfigissue"
        //noinspection OldTargetApi
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

    buildFeatures {
        compose = true
    }

    productFlavors {
        getByName("staging") {
            dimension = "my-dimension"
            isDefault = true
            applicationIdSuffix = ".staging"
            buildConfigField("String", "APP_NAME", "\"Sunshine Dev\"")
        }
        getByName("prod") {
            dimension = "my-dimension"
            buildConfigField("String", "APP_NAME", "\"Sunshine\"")
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    implementation(project(":library"))
}
