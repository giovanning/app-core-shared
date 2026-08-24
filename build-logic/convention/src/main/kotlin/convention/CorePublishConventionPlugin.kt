package convention

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.publish.PublishingExtension
import org.gradle.api.publish.maven.MavenPublication
import org.gradle.kotlin.dsl.*

/**
 * Convention plugin de publicação para os módulos :core:*.
 *
 * Exige que o módulo consumidor aplique com.android.library — este plugin
 * publica exclusivamente o componente "release" (AAR). Módulos Kotlin JVM
 * puro (sem com.android.library) não são suportados: aplique o plugin
 * android-library convention no módulo antes deste.
 *
 * Espera a versão no build.gradle.kts do módulo consumidor:
 *   version = "1.0.0"
 */
class CorePublishConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("maven-publish")

            pluginManager.withPlugin("com.android.library") {
                // no-op: só documenta a dependência esperada, a checagem real
                // acontece no afterEvaluate abaixo (com.android.library ainda
                // não terminou de configurar `components` neste ponto do ciclo)
            }

            afterEvaluate {
                check(plugins.hasPlugin("com.android.library")) {
                    "O módulo '${project.path}' precisa aplicar com.android.library " +
                            "para usar convention.core-publish (publica apenas AAR)."
                }

                extensions.configure<PublishingExtension> {
                    publications {
                        create<MavenPublication>("release") {
                            groupId = project.group.toString()
                            artifactId = project.name
                            version = project.version.toString()

                            from(components.getByName("release"))

                            pom {
                                name.set(project.name)
                                description.set("Biblioteca core compartilhada entre os apps")
                            }
                        }
                    }

                    repositories {
                        maven {
                            name = "GitHubPackages"
                            url = uri("https://maven.pkg.github.com/giovanning/app-core-shared")
                            credentials {
                                username = System.getenv("GITHUB_ACTOR")
                                password = System.getenv("GITHUB_TOKEN")
                            }
                        }
                    }
                }
            }
        }
    }
}
