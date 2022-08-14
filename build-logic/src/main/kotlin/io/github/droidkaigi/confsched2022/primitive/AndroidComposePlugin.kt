package io.github.droidkaigi.confsched2022.primitive

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

@Suppress("unused")
class AndroidComposePlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            android {
                buildFeatures.compose = true
                composeOptions {
                    kotlinCompilerExtensionVersion = libs.findVersion("composeCompiler").get().toString()
                }
            }
            dependencies {
                // FIXME: Without this, we can not use 1.2 and comiple error
                add("kotlinCompilerPluginClasspath", libs.findLibrary("composeCompiler").get())

                implementation(libs.findLibrary("androidxCoreKtx"))
                implementation(libs.findLibrary("composeUi"))
                implementation(libs.findLibrary("composeMaterial3"))
                implementation(libs.findLibrary("composeUiToolingPreview"))
                implementation(libs.findLibrary("androidxLifecycleLifecycleRuntimeKtx"))
                implementation(libs.findLibrary("androidxActivityCompose"))
                testImplementation(libs.findLibrary("junit"))
                androidTestImplementation(libs.findLibrary("androidxTestExtJunit"))
                androidTestImplementation(libs.findLibrary("androidxTestEspressoEspressoCore"))
                androidTestImplementation(libs.findLibrary("composeUiTestJunit4"))
                debugImplementation(libs.findLibrary("composeUiTooling"))
                debugImplementation(libs.findLibrary("composeUiTestManifest"))
            }
        }
    }
}
