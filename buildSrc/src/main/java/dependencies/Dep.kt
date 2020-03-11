package dependencies

object Dep {
    object GradlePlugin {
        val android = "com.android.tools.build:gradle:3.6.1"
        val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Kotlin.version}"
        val safeArgs = "androidx.navigation:navigation-safe-args-gradle-plugin:${AndroidX.Navigation.version}"
        val crashlytics = "com.google.firebase:firebase-crashlytics-gradle:2.0.0-beta01"
    }

    object Test {
        val junit = "junit:junit:4.12"
        val testRunner = "androidx.test:runner:1.3.0-alpha02"
        val testRules = "androidx.test:rules:1.3.0-alpha02"
        val testCoreKtx = "androidx.test:core-ktx:1.2.1-alpha02"
        val androidJunit4Ktx = "androidx.test.ext:junit-ktx:1.1.2-alpha02"
        val orchestrator = "androidx.test:orchestrator:1.3.0-alpha02"
        val archCore = "androidx.arch.core:core-testing:2.1.0"
        val liveDataTestingKtx = "com.jraska.livedata:testing-ktx:1.1.0"
        val espressoCore = "androidx.test.espresso:espresso-core:3.3.0-alpha02"
        val coroutinesTest =
            "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Kotlin.coroutinesVersion}"
        val kotlinTestAssertions = "io.kotlintest:kotlintest-assertions:3.1.10"
        val testingKtx =
            "androidx.navigation:navigation-testing-ktx:${AndroidX.Navigation.version}"
    }

    object AndroidX {
        val appCompat = "androidx.appcompat:appcompat:1.1.0"
        val recyclerView = "androidx.recyclerview:recyclerview:1.1.0"
        val constraint = "androidx.constraintlayout:constraintlayout:2.0.0-beta4"
        val emoji = "androidx.emoji:emoji-appcompat:1.0.0"
        val design = "com.google.android.material:material:1.2.0-alpha05"
        val coreKtx = "androidx.core:core-ktx:1.2.0-rc01"
        val preference = "androidx.preference:preference:1.1.0"
        val activityKtx = "androidx.activity:activity-ktx:1.1.0"
        val fragmentKtx = "androidx.fragment:fragment-ktx:1.2.2"

        val lifecycleLiveData = "androidx.lifecycle:lifecycle-livedata:2.2.0"
        val liveDataCoreKtx = "androidx.lifecycle:lifecycle-livedata-core-ktx:2.2.0"
        val liveDataKtx = "androidx.lifecycle:lifecycle-livedata-ktx:2.2.0"

        object Room {
            val version = "2.2.3"
            val compiler = "androidx.room:room-compiler:$version"
            val runtime = "androidx.room:room-runtime:$version"
            val coroutine = "androidx.room:room-ktx:$version"
        }

        object Navigation {
            val version = "2.2.1"
            val runtimeKtx = "androidx.navigation:navigation-runtime-ktx:$version"
            val fragmentKtx = "androidx.navigation:navigation-fragment-ktx:$version"
            val uiKtx = "androidx.navigation:navigation-ui-ktx:$version"
            val dynamicFeaturesFragment =
                "androidx.navigation:navigation-dynamic-features-fragment:2.3.0-SNAPSHOT"
            val dynamicFeaturesRuntime =
                "androidx.navigation:navigation-dynamic-features-runtime:2.3.0-SNAPSHOT"
        }
    }

    object Kotlin {
        val version = "1.3.61"
        val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$version"
        val coroutinesVersion = "1.3.3"
        val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion"
        val androidCoroutinesDispatcher =
            "org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutinesVersion"
        val coroutinesReactive =
            "org.jetbrains.kotlinx:kotlinx-coroutines-reactive:$coroutinesVersion"
    }

    object Firebase {
        val core = "com.google.firebase:firebase-core:16.0.4"
        val firestoreKtx = "com.google.firebase:firebase-firestore-ktx:20.2.0"
        val auth = "com.google.firebase:firebase-auth:18.1.0"
        val crashlytics = "com.google.firebase:firebase-crashlytics:17.0.0-beta01"
        val analytics = "com.google.firebase:firebase-analytics:17.2.2"
        val messaging = "com.google.firebase:firebase-messaging:20.1.0"
    }

    object OkHttp {
        val version = "4.0.1"
        val client = "com.squareup.okhttp3:okhttp:$version"
        val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:$version"
        val okio = "com.squareup.okio:okio:1.14.0"
    }

    object Retrofit {
        val version = "2.7.2"
        val retrofit = "com.squareup.retrofit2:retrofit:$version"
        val converter = "com.squareup.retrofit2:converter-moshi:$version"
        val coroutine = "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:0.9.2"

    }

    val liveEvent = "com.github.hadilq.liveevent:liveevent:1.0.1"

    object LeakCanary {
        val version = "2.1"
        val leakCanary = "com.squareup.leakcanary:leakcanary-android:$version"
    }

    object Stetho {
        val stetho = "com.facebook.stetho:stetho:1.5.1"
    }

    object Hyperion {
        val version = "0.9.27"
        val hyperionPlugins = listOf(
            "com.willowtreeapps.hyperion:hyperion-core:$version",
            "com.willowtreeapps.hyperion:hyperion-attr:$version",
            "com.willowtreeapps.hyperion:hyperion-measurement:$version",
            "com.willowtreeapps.hyperion:hyperion-disk:$version",
            "com.willowtreeapps.hyperion:hyperion-recorder:$version",
            "com.willowtreeapps.hyperion:hyperion-phoenix:$version",
            "com.willowtreeapps.hyperion:hyperion-crash:$version",
            "com.willowtreeapps.hyperion:hyperion-shared-preferences:$version",
            "com.willowtreeapps.hyperion:hyperion-geiger-counter:$version",
            "com.willowtreeapps.hyperion:hyperion-build-config:$version",
            "com.willowtreeapps.hyperion:hyperion-plugin:$version"
        )
    }

    object Koin {
        val version = "2.0.1"
        val koin = "org.koin:koin-android:$version"
        val lifecycle = "org.koin:koin-android-scope:$version"
        val viewModel = "org.koin:koin-android-viewmodel:$version"

    }

    object Epoxy {
        val version = "3.9.0"
        val epoxy = "com.airbnb.android:epoxy:$version"
        val processer = "com.airbnb.android:epoxy-processor:$version"
        val databindingSupport = "com.airbnb.android:epoxy-databinding:3.9.0"
    }

    object Coil {
        val version = "0.9.5"
        val coil = "io.coil-kt:coil:$version"
    }

    object MockK {
        val jvm = "io.mockk:mockk:1.9.3"
        val common = "io.mockk:mockk-common:1.9.3"
    }

    object Timber {
        val common = "com.jakewharton.timber:timber-common:5.0.0-SNAPSHOT"
        val jdk = "com.jakewharton.timber:timber-jdk:5.0.0-SNAPSHOT"
        val android = "com.jakewharton.timber:timber-android:5.0.0-SNAPSHOT"
    }
}