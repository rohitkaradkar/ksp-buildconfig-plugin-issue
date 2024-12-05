package com.sample.configs

import com.android.build.api.dsl.CommonExtension

const val FLAVOR_DIMENSION = "my-dimension"
const val FLAVOR_STAGING = "staging"
const val FLAVOR_PROD = "prod"

internal fun configureFlavors(extension: CommonExtension<*, *, *, *, *, *>) {
    extension.apply {
        flavorDimensions += FLAVOR_DIMENSION
        productFlavors {
            create(FLAVOR_STAGING) {
                dimension = FLAVOR_DIMENSION
            }
            create(FLAVOR_PROD) {
                dimension = FLAVOR_DIMENSION
            }
        }
    }
}
