import org.gradle.kotlin.dsl.android

plugins {
    alias(libs.plugins.android.library)
//    alias(libs.plugins.ksp)
    kotlin("android")
    kotlin("kapt")
    alias(libs.plugins.hilt)
}
java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}
//kotlin {
    android {
        kotlin {
            compilerOptions {
                jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_11)
            }
        }
        namespace = "com.zaptec.test.support"
        compileSdk {
            version = release(36) {
                minorApiLevel = 1
            }
        }

        flavorDimensions.add("environment")
        productFlavors {
            create("devComplete") {
                dimension = "environment"
            }
        }
    }

    dependencies{
        implementation(libs.hilt.android)
//        ksp(libs.hilt.compiler)
        kapt(libs.hilt.compiler)
    }
//}

kapt {
    correctErrorTypes = true
}
