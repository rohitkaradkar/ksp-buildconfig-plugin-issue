repositories {
    gradlePluginPortal()
    google()
    mavenCentral()
}

plugins {
    `kotlin-dsl`
}

dependencies {
    implementation(files(libs.javaClass.superclass.protectionDomain.codeSource.location))
    implementation(libs.kotlin.gradlePlugin)
    implementation(libs.android.gradlePlugin)
}

gradlePlugin {
    plugins {
        create("androidApplicationPlugin") {
            id = "sampleapp.android.application"
            implementationClass = "AndroidApplicationPlugin"
        }
        create("androidLibraryPlugin") {
            id = "sampleapp.android.library"
            implementationClass = "AndroidLibraryPlugin"
        }
        create("androidHiltPlugin") {
            id = "sampleapp.android.hilt"
            implementationClass = "AndroidHiltPlugin"
        }
    }
}
