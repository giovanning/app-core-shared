plugins {
    `kotlin-dsl`
}

group = "com.projetos.filmei.buildlogic"

repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
}

dependencies {
    // necessário para o convention plugin conseguir aplicar com.android.library
    // e org.jetbrains.kotlin.android internamente
    compileOnly("com.android.tools.build:gradle:8.6.0")
    compileOnly("org.jetbrains.kotlin:kotlin-gradle-plugin:2.0.20")
}

gradlePlugin {
    plugins {
        register("corePublish") {
            id = "convention.core-publish"
            implementationClass = "convention.CorePublishConventionPlugin"
        }
    }
}
