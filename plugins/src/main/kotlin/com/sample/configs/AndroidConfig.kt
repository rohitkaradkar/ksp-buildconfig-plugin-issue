package com.sample.configs

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.dsl.KotlinAndroidProjectExtension

internal fun Project.configureKotlinAndroid(extension: CommonExtension<*, *, *, *, *, *>) {
    val libs = getVersionCatalog()
    extension.apply {
        with(pluginManager) {
            apply(libs.plugins.kotlin.android.get().pluginId)
        }

        compileSdk = 34
        defaultConfig {
            minSdk = 24
        }

        compileOptions {
            isCoreLibraryDesugaringEnabled = true
            sourceCompatibility = JavaVersion.VERSION_17
            targetCompatibility = JavaVersion.VERSION_17
        }

        buildFeatures {
            buildConfig = true
        }

        configure<KotlinAndroidProjectExtension> {
            compilerOptions.jvmTarget.set(JvmTarget.JVM_17)
        }

        dependencies {
            add("coreLibraryDesugaring", libs.corelibrarydesugaring)
        }
    }
}
