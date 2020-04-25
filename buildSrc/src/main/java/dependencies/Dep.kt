package dependencies

object Dep {
    private object LibsVersion {
        val Kotlin = "1.3.61"
        val KotlinCoroutines = "1.3.3"
        val Room = "2.2.3"
        val Navigation = "2.2.1"
        val Okhttp = "4.0.1"
        val Retrofit = "2.7.2"
        val Moshi = "1.9.2"
        val Hyperion = "0.9.27"
        val Ktlint = "0.36.0"
        val Koin = "2.0.1"
        val Epoxy = "3.9.0"
        val Coil = "0.9.5"
        val MockK = "1.9.3"
        val Timber = "4.7.1"
        val Stetho = "1.5.1"
        val DynamicFutureFragment = "2.3.0-SNAPSHOT"
        val LiveData = "2.2.0"
        val JitPack = "1.0.0"
        val ViewPager2 = "1.0.0"
        val Dokka = "0.10.1"
    }

    object GradlePlugin {
        val android = "com.android.tools.build:gradle:3.6.1"
        val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${LibsVersion.Kotlin}"
        val safeArgs =
            "androidx.navigation:navigation-safe-args-gradle-plugin:${LibsVersion.Navigation}"
        val playServices = "com.google.gms:google-services:4.3.3"
        val crashlytics = "com.google.firebase:firebase-crashlytics-gradle:2.0.0-beta01"
        val dokka = "org.jetbrains.dokka:dokka-gradle-plugin:${LibsVersion.Dokka}"
        val dokkaPlugin = "org.jetbrains.dokka"
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
            "org.jetbrains.kotlinx:kotlinx-coroutines-test:${LibsVersion.KotlinCoroutines}"
        val kotlinTestAssertions = "io.kotlintest:kotlintest-assertions:3.1.10"
        val testingKtx =
            "androidx.navigation:navigation-testing-ktx:${LibsVersion.Navigation}"
    }

    object AndroidX {
        val appCompat = "androidx.appcompat:appcompat:1.1.0"
        val recyclerView = "androidx.recyclerview:recyclerview:1.1.0"
        val swipeRefresh = "androidx.swiperefreshlayout:swiperefreshlayout:1.0.0"
        val constraint = "androidx.constraintlayout:constraintlayout:2.0.0-beta4"
        val emoji = "androidx.emoji:emoji-appcompat:1.0.0"
        val design = "com.google.android.material:material:1.2.0-alpha05"
        val coreKtx = "androidx.core:core-ktx:1.2.0-rc01"
        val preference = "androidx.preference:preference:1.1.0"
        val activityKtx = "androidx.activity:activity-ktx:1.1.0"
        val fragmentKtx = "androidx.fragment:fragment-ktx:1.2.2"

        val lifecycleLiveData = "androidx.lifecycle:lifecycle-livedata:${LibsVersion.LiveData}"
        val liveDataCoreKtx =
            "androidx.lifecycle:lifecycle-livedata-core-ktx:${LibsVersion.LiveData}"
        val liveDataKtx = "androidx.lifecycle:lifecycle-livedata-ktx:${LibsVersion.LiveData}"

        val viewPager2 = "androidx.viewpager2:viewpager2:${LibsVersion.ViewPager2}"

        object Room {
            val compiler = "androidx.room:room-compiler:${LibsVersion.Room}"
            val runtime = "androidx.room:room-runtime:${LibsVersion.Room}"
            val coroutine = "androidx.room:room-ktx:${LibsVersion.Room}"
        }

        object Navigation {
            val runtimeKtx = "androidx.navigation:navigation-runtime-ktx:${LibsVersion.Navigation}"
            val fragmentKtx =
                "androidx.navigation:navigation-fragment-ktx:${LibsVersion.Navigation}"
            val uiKtx = "androidx.navigation:navigation-ui-ktx:${LibsVersion.Navigation}"
            val dynamicFeaturesFragment =
                "androidx.navigation:navigation-dynamic-features-fragment:${LibsVersion.DynamicFutureFragment}"
            val dynamicFeaturesRuntime =
                "androidx.navigation:navigation-dynamic-features-runtime:${LibsVersion.DynamicFutureFragment}"
        }
    }

    object Kotlin {
        val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${LibsVersion.Kotlin}"
        val coroutines =
            "org.jetbrains.kotlinx:kotlinx-coroutines-core:${LibsVersion.KotlinCoroutines}"
        val androidCoroutinesDispatcher =
            "org.jetbrains.kotlinx:kotlinx-coroutines-android:${LibsVersion.KotlinCoroutines}"
    }

    object Firebase {
        val core = "com.google.firebase:firebase-core:16.0.4"
        val firestoreKtx = "com.google.firebase:firebase-firestore-ktx:20.2.0"
        val auth = "com.google.firebase:firebase-auth:18.1.0"
        val ui = "com.firebaseui:firebase-ui-auth:4.3.1"
        val crashlytics = "com.google.firebase:firebase-crashlytics:17.0.0-beta01"
        val analytics = "com.google.firebase:firebase-analytics:17.2.2"
        val messaging = "com.google.firebase:firebase-messaging:20.1.0"
    }

    object OkHttp {
        val client = "com.squareup.okhttp3:okhttp:${LibsVersion.Okhttp}"
        val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${LibsVersion.Okhttp}"
        val okio = "com.squareup.okio:okio:1.14.0"
    }

    object Retrofit {
        val retrofit = "com.squareup.retrofit2:retrofit:${LibsVersion.Retrofit}"
        val converter = "com.squareup.retrofit2:converter-moshi:${LibsVersion.Retrofit}"
        val coroutine = "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:0.9.2"
    }

    object Moshi {
        val moshi = "com.squareup.moshi:moshi:${LibsVersion.Moshi}"
        val kotlin = "com.squareup.moshi:moshi-kotlin:${LibsVersion.Moshi}"
    }

    val liveEvent = "com.github.hadilq.liveevent:liveevent:1.0.1"

    object LeakCanary {
        val LibsVersion = "2.1"
        val leakCanary = "com.squareup.leakcanary:leakcanary-android:$LibsVersion"
    }

    object Stetho {
        val stetho = "com.facebook.stetho:stetho:${LibsVersion.Stetho}"
    }

    object Hyperion {

        val core = "com.willowtreeapps.hyperion:hyperion-core:${LibsVersion.Hyperion}"
        val attr = "com.willowtreeapps.hyperion:hyperion-attr:${LibsVersion.Hyperion}"
        val measurement =
            "com.willowtreeapps.hyperion:hyperion-measurement:${LibsVersion.Hyperion}"
        val disk = "com.willowtreeapps.hyperion:hyperion-disk:${LibsVersion.Hyperion}"
        val recorder = "com.willowtreeapps.hyperion:hyperion-recorder:${LibsVersion.Hyperion}"
        val phoenix = "com.willowtreeapps.hyperion:hyperion-phoenix:${LibsVersion.Hyperion}"
        val crash = "com.willowtreeapps.hyperion:hyperion-crash:${LibsVersion.Hyperion}"
        val preferences =
            "com.willowtreeapps.hyperion:hyperion-shared-preferences:${LibsVersion.Hyperion}"
        val counter = "com.willowtreeapps.hyperion:hyperion-geiger-counter:${LibsVersion.Hyperion}"
        val buildConfig =
            "com.willowtreeapps.hyperion:hyperion-build-config:${LibsVersion.Hyperion}"
        val plugin = "com.willowtreeapps.hyperion:hyperion-plugin:${LibsVersion.Hyperion}"
        val timber = "com.willowtreeapps.hyperion:hyperion-timber:${LibsVersion.Hyperion}"

        val http = "com.github.Commit451:Hyperion-Chuck:${LibsVersion.JitPack}"
    }

    object Ktlint {
        val ktlint = "com.pinterest:ktlint:${LibsVersion.Ktlint}"
    }

    object Koin {
        val koin = "org.koin:koin-android:${LibsVersion.Koin}"
        val lifecycle = "org.koin:koin-android-scope:${LibsVersion.Koin}"
        val viewModel = "org.koin:koin-android-viewmodel:${LibsVersion.Koin}"
    }

    object Epoxy {
        val epoxy = "com.airbnb.android:epoxy:${LibsVersion.Epoxy}"
        val processer = "com.airbnb.android:epoxy-processor:${LibsVersion.Epoxy}"
        val databindingSupport = "com.airbnb.android:epoxy-databinding:${LibsVersion.Epoxy}"
    }

    object Coil {
        val coil = "io.coil-kt:coil:${LibsVersion.Coil}"
    }

    object MockK {
        val jvm = "io.mockk:mockk:${LibsVersion.MockK}"
        val common = "io.mockk:mockk-common:${LibsVersion.MockK}"
    }

    object Timber {
        val timber = "com.jakewharton.timber:timber:${LibsVersion.Timber}"
    }

    object Play {
        val playCore = "com.google.android.play:core:1.6.4"
    }
}
