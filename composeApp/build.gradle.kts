import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
//buildscript {
//    repositories {
//        google()
//        mavenCentral()
//    }
////    dependencies {
////        classpath("com.google.gms:google-services:4.3.15")
////    }
//}
plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
    id("com.google.gms.google-services")
    kotlin("plugin.serialization") version "2.1.0"
}
//repositories{
//    google()
//    mavenCentral()
//    maven("https://maven.pkg.jetbrains.space/public/p/kotlinx-coroutines/maven")
//    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
//}
kotlin {
    androidTarget {
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_17)
        }
    }
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "ComposeApp"
            isStatic = true
        }
    }
    
    sourceSets {
        
        androidMain.dependencies {
            implementation(compose.preview)
            implementation(libs.androidx.activity.compose)
//            implementation("com.google.firebase:firebase-auth-ktx:22.1.2")
//            implementation("com.google.firebase:firebase-firestore-ktx:24.10.0")
//            implementation("org.jetbrains.kotlinx:kotlinx-coroutines-play-services:1.6.4")
//            implementation("com.google.firebase:firebase-storage-ktx:20.3.0")

//            implementation(platform("com.google.firebase:firebase-bom:33.9.0"))
//            implementation("com.google.firebase:firebase-auth-ktx")
//            implementation("com.google.firebase:firebase-database-ktx")
//            implementation("com.google.firebase:firebase-common-ktx")
//            implementation("com.google.firebase:firebase-common")
//            implementation("com.google.firebase:firebase-firestore-ktx")
            //implementation("com.google.firebase:firebase-storage-ktx")
//            implementation("androidx.compose.ui:ui-res:1.0.5")
            //implementation("androidx.compose.ui:ui:1.5.0") // Ensure you have the latest version
//            implementation("androidx.compose.ui:ui-tooling:1.5.0")
//            implementation("androidx.compose.ui:ui-res:1.5.0")
            implementation("dev.gitlive:firebase-auth:1.10.0")
            implementation("dev.gitlive:firebase-firestore:1.10.0")



        }
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
            implementation(libs.androidx.lifecycle.viewmodel)
            implementation(libs.androidx.lifecycle.runtime.compose)
            implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
            implementation("dev.gitlive:firebase-auth:1.10.0")
            implementation("dev.gitlive:firebase-firestore:1.10.0")
            implementation("org.jetbrains.androidx.navigation:navigation-compose:2.8.0-alpha10")
            implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.1")


//            // Ktor dependencies
            implementation("io.ktor:ktor-client-core:2.0.0")
            implementation("io.ktor:ktor-client-cio:2.0.0")
            implementation("io.ktor:ktor-client-serialization:2.0.0")
            implementation("io.ktor:ktor-client-json:2.3.5")
//            implementation("com.google.firebase:firebase-database-ktx:20.0.0")
            implementation(libs.coil.compose)
            implementation(libs.coil.network.ktor)
//            implementation("androidx.compose.ui:ui-res:1.0.5")
            implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.4.0")
            implementation("org.jetbrains.kotlinx:kotlinx-io:0.1.16")
            implementation("com.squareup.okio:okio:3.3.0")
        }

    }
}

android {
    namespace = "org.example.project"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    defaultConfig {
        applicationId = "org.example.project"
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

dependencies {
    debugImplementation(compose.uiTooling)
    implementation(libs.androidx.material3.android)
//    implementation(libs.firebase.auth.ktx)
    implementation(libs.androidx.navigation.compose)
//    implementation(libs.firebase.common.ktx)
//    implementation(libs.firebase.common)
}

apply(plugin="com.google.gms.google-services")

dependencies {
    implementation(libs.androidx.ui.android)
//    implementation(libs.firebase.database.ktx)
    implementation(libs.androidx.ui.graphics.android)
}
//configurations.all {
//    resolutionStrategy {
//        force("com.google.firebase:firebase-common:20.0.0")
//    }
//}