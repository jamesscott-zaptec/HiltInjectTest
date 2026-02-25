plugins {
    id(libs.plugins.android.library.get().pluginId)
    alias(libs.plugins.ksp)
    alias(libs.plugins.hilt)
}
java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}
kotlin {
    compilerOptions {
        jvmTarget = org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_11
    }
    android {
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
        ksp(libs.hilt.compiler)
    }
}
