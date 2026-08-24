plugins {
    alias(libs.plugins.android.library)
    id("convention.core-publish")
}

version = "1.0.0"

android {
    namespace = "com.projetos.filmei.domain"
    compileSdk {
        version = release(36) {
            minorApiLevel = 1
        }
    }

    defaultConfig {
        minSdk = 26
    }

    publishing {
        singleVariant("release") {
            withSourcesJar()
        }
    }
}

dependencies {

}