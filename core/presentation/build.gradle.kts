plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.compose.compiler)
    id("convention.core-publish")
}

version = "1.0.0"

android {
    namespace = "com.projetos.filmei.presentation"
    compileSdk {
        version = release(36) {
            minorApiLevel = 1
        }
    }

    defaultConfig {
        minSdk = 26

    }

    buildFeatures {
        compose = true
    }

    publishing {
        singleVariant("release") {
            withSourcesJar()
        }
    }

}

dependencies {
    api(project(":core:domain"))
    api(project(":core:design-system"))

    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui)
    implementation(libs.kotlin.coroutines.core)
}