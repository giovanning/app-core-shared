plugins {
    alias(libs.plugins.android.library)
    id("convention.core-publish")
}

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