plugins {
    alias(libs.plugins.sampleapp.android.library)
}

android {
    namespace = "com.example.library"
    compileSdk = 34

    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    productFlavors {
        getByName("staging") {
            dimension = "my-dimension"
            buildConfigField("int", "PORT_NO", "21")
        }
        getByName("prod") {
            dimension = "my-dimension"
            buildConfigField("int", "PORT_NO", "31")
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
