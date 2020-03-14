package dependencies

object Dep {
    private object Version{
        val KotlinVersion = "1.3.61"
        val KotlinCoroutinesVersion = "1.3.3"
        val RoomVersion = "2.2.3"
        val NavigationVersion = "2.2.1"
        val OkhttpVersion = "4.0.1"
        val RetrofitVersion = "2.7.2"
        val HyperionVersion = "0.9.27"
        val KoinVersion = "2.0.1"
        val EpoxyVersion = "3.9.0"
        val CoilVersion = "0.9.5"
        val MockKVersion = "1.9.3"
        val TimberVersion = "5.0.0-SNAPSHOT"
        val StethoVersion = "1.5.1"
        val DynamicFutureFragment = "2.3.0-SNAPSHOT"
        val LiveDataVersion = "2.2.0"
    }


    object GradlePlugin {
        val android = "com.android.tools.build:gradle:3.6.1"
        val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Version.KotlinVersion}"
        val safeArgs = "androidx.navigation:navigation-safe-args-gradle-plugin:${Version.NavigationVersion}"
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
            "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Version.KotlinCoroutinesVersion}"
        val kotlinTestAssertions = "io.kotlintest:kotlintest-assertions:3.1.10"
        val testingKtx =
            "androidx.navigation:navigation-testing-ktx:${Version.NavigationVersion}"
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

        val lifecycleLiveData = "androidx.lifecycle:lifecycle-livedata:${Version.LiveDataVersion}"
        val liveDataCoreKtx = "androidx.lifecycle:lifecycle-livedata-core-ktx:${Version.LiveDataVersion}"
        val liveDataKtx = "androidx.lifecycle:lifecycle-livedata-ktx:${Version.LiveDataVersion}"

        object Room {
            val compiler = "androidx.room:room-compiler:${Version.RoomVersion}"
            val runtime = "androidx.room:room-runtime:${Version.RoomVersion}"
            val coroutine = "androidx.room:room-ktx:${Version.RoomVersion}"
        }

        object Navigation {
            val runtimeKtx = "androidx.navigation:navigation-runtime-ktx:${Version.NavigationVersion}"
            val fragmentKtx = "androidx.navigation:navigation-fragment-ktx:${Version.NavigationVersion}"
            val uiKtx = "androidx.navigation:navigation-ui-ktx:${Version.NavigationVersion}"
            val dynamicFeaturesFragment =
                "androidx.navigation:navigation-dynamic-features-fragment:${Version.DynamicFutureFragment}"
            val dynamicFeaturesRuntime =
                "androidx.navigation:navigation-dynamic-features-runtime:${Version.DynamicFutureFragment}"
        }
    }

    object Kotlin {

        val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Version.KotlinVersion}"

        val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Version.KotlinCoroutinesVersion}"
        val androidCoroutinesDispatcher =
            "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Version.KotlinCoroutinesVersion}"
        val coroutinesReactive =
            "org.jetbrains.kotlinx:kotlinx-coroutines-reactive:${Version.KotlinCoroutinesVersion}"

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
        val client = "com.squareup.okhttp3:okhttp:${Version.OkhttpVersion}"
        val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Version.OkhttpVersion}"
        val okio = "com.squareup.okio:okio:1.14.0"
    }

    object Retrofit {
        val retrofit = "com.squareup.retrofit2:retrofit:${Version.RetrofitVersion}"
        val converter = "com.squareup.retrofit2:converter-moshi:${Version.RetrofitVersion}"
        val coroutine = "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:0.9.2"

    }

    val liveEvent = "com.github.hadilq.liveevent:liveevent:1.0.1"

    object LeakCanary {
        val version = "2.1"
        val leakCanary = "com.squareup.leakcanary:leakcanary-android:$version"
    }

    object Stetho {
        val stetho = "com.facebook.stetho:stetho:${Version.StethoVersion}"
    }

    object Hyperion {

        val hyperionPlugins = listOf(
            "com.willowtreeapps.hyperion:hyperion-core:${Version.HyperionVersion}",
            "com.willowtreeapps.hyperion:hyperion-attr:${Version.HyperionVersion}",
            "com.willowtreeapps.hyperion:hyperion-measurement:${Version.HyperionVersion}",
            "com.willowtreeapps.hyperion:hyperion-disk:${Version.HyperionVersion}",
            "com.willowtreeapps.hyperion:hyperion-recorder:${Version.HyperionVersion}",
            "com.willowtreeapps.hyperion:hyperion-phoenix:${Version.HyperionVersion}",
            "com.willowtreeapps.hyperion:hyperion-crash:${Version.HyperionVersion}",
            "com.willowtreeapps.hyperion:hyperion-shared-preferences:${Version.HyperionVersion}",
            "com.willowtreeapps.hyperion:hyperion-geiger-counter:${Version.HyperionVersion}",
            "com.willowtreeapps.hyperion:hyperion-build-config:${Version.HyperionVersion}",
            "com.willowtreeapps.hyperion:hyperion-plugin:${Version.HyperionVersion}"
        )
    }

    object Koin {
        val koin = "org.koin:koin-android:${Version.KoinVersion}"
        val lifecycle = "org.koin:koin-android-scope:${Version.KoinVersion}"
        val viewModel = "org.koin:koin-android-viewmodel:${Version.KoinVersion}"
    }

    object Epoxy {
        val epoxy = "com.airbnb.android:epoxy:${Version.EpoxyVersion}"
        val processer = "com.airbnb.android:epoxy-processor:${Version.EpoxyVersion}"
    }

    object Coil {
        val coil = "io.coil-kt:coil:${Version.CoilVersion}"
    }

    object MockK {
        val jvm = "io.mockk:mockk:${Version.MockKVersion}"
        val common = "io.mockk:mockk-common:${Version.MockKVersion}"
    }

    object Timber {
        val common = "com.jakewharton.timber:timber-common:${Version.TimberVersion}"
        val jdk = "com.jakewharton.timber:timber-jdk:${Version.TimberVersion}"
        val android = "com.jakewharton.timber:timber-android:${Version.TimberVersion}"
    }
}
