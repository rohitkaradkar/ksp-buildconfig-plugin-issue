package com.sample.configs

import org.gradle.accessors.dm.LibrariesForLibs
import org.gradle.api.Project

internal fun Project.getVersionCatalog() = project.extensions.getByName("libs") as LibrariesForLibs
