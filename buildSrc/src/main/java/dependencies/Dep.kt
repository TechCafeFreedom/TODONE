package dependencies

object Dep {
    private object LibsVersion {
        const val kotlin = "1.5.10"
        const val kotlinCoroutines = "1.5.1"
        const val room = "2.3.0"
        const val navigation = "2.3.5"
        const val okhttp = "4.9.0"
        const val retrofit = "2.9.0"
        const val moshi = "1.12.0"
        const val hyperion = "0.9.31"
        const val ktlint = "0.36.0"
        const val epoxy = "3.9.0"
        const val timber = "4.7.1"
        const val liveData = "2.3.1"
        const val jitPack = "1.1.2"
        const val viewPager2 = "1.0.0"
        const val dokka = "0.9.17"
        const val hilt = "2.37"
        const val compose = "1.0.0-rc01"
        const val takahirom = "0.5.0"
        const val fragment = "1.3.5"
        const val test = "1.4.0"
    }

    object GradlePlugin {
        const val android = "com.android.tools.build:gradle:4.2.2"
        const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${LibsVersion.kotlin}"
        const val safeArgs =
            "androidx.navigation:navigation-safe-args-gradle-plugin:${LibsVersion.navigation}"
        const val playServices = "com.google.gms:google-services:4.3.3"
        const val crashlytics = "com.google.firebase:firebase-crashlytics-gradle:2.0.0-beta01"
        const val dokka = "org.jetbrains.dokka:dokka-gradle-plugin:${LibsVersion.dokka}"
        const val dokkaPlugin = "org.jetbrains.dokka"
        const val hilt = "com.google.dagger:hilt-android-gradle-plugin:${LibsVersion.hilt}"
    }

    object Test {
        const val junit = "junit:junit:4.12"
        const val testRunner = "androidx.test:runner:${LibsVersion.test}"
        const val testRules = "androidx.test:rules:${LibsVersion.test}"
        const val testCoreKtx = "androidx.test:core-ktx:${LibsVersion.test}"
        const val androidJunit4Ktx = "androidx.test.ext:junit-ktx:1.1.2"
        const val orchestrator = "androidx.test:orchestrator:${LibsVersion.test}"
        const val archCore = "androidx.arch.core:core-testing:2.1.0"
        const val liveDataTestingKtx = "com.jraska.livedata:testing-ktx:1.1.0"
        const val espressoCore = "androidx.test.espresso:espresso-core:3.3.0-alpha02"
        const val coroutinesTest =
            "org.jetbrains.kotlinx:kotlinx-coroutines-test:${LibsVersion.kotlinCoroutines}"
        const val kotlinTestAssertions = "io.kotlintest:kotlintest-assertions:3.1.10"
        const val testingKtx = "androidx.navigation:navigation-testing-ktx:${LibsVersion.navigation}"
        const val fragmentTesting = "androidx.fragment:fragment-testing:${LibsVersion.fragment}"
    }

    object AndroidX {
        const val appCompat = "androidx.appcompat:appcompat:1.3.0"
        const val recyclerView = "androidx.recyclerview:recyclerview:1.2.1"
        const val constraint = "androidx.constraintlayout:constraintlayout:2.0.4"
        const val design = "com.google.android.material:material:1.4.0"
        const val coreKtx = "androidx.core:core-ktx:1.6.0"
        const val preference = "androidx.preference:preference:1.1.1"
        const val activityKtx = "androidx.activity:activity-ktx:1.2.3"
        const val fragmentKtx = "androidx.fragment:fragment-ktx:${LibsVersion.fragment}"

        const val lifecycleLiveData = "androidx.lifecycle:lifecycle-livedata:${LibsVersion.liveData}"
        const val liveDataCoreKtx =
            "androidx.lifecycle:lifecycle-livedata-core-ktx:${LibsVersion.liveData}"
        const val liveDataKtx = "androidx.lifecycle:lifecycle-livedata-ktx:${LibsVersion.liveData}"

        const val viewPager2 = "androidx.viewpager2:viewpager2:${LibsVersion.viewPager2}"

        object Room {
            const val compiler = "androidx.room:room-compiler:${LibsVersion.room}"
            const val runtime = "androidx.room:room-runtime:${LibsVersion.room}"
            const val coroutine = "androidx.room:room-ktx:${LibsVersion.room}"
        }

        object Navigation {
            const val runtimeKtx = "androidx.navigation:navigation-runtime-ktx:${LibsVersion.navigation}"
            const val fragmentKtx =
                "androidx.navigation:navigation-fragment-ktx:${LibsVersion.navigation}"
            const val uiKtx = "androidx.navigation:navigation-ui-ktx:${LibsVersion.navigation}"
        }

        object Compose {
            const val ui = "androidx.compose.ui:ui:${LibsVersion.compose}"
            const val foundation = "androidx.compose.foundation:foundation:${LibsVersion.compose}"
            const val material = "androidx.compose.material:material:${LibsVersion.compose}"
            const val runtime = "androidx.compose.runtime:runtime:${LibsVersion.compose}"
        }
    }

    object Kotlin {
        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${LibsVersion.kotlin}"
        const val stdlibCommon = "org.jetbrains.kotlin:kotlin-stdlib-common:${LibsVersion.kotlin}"
        const val coroutines =
            "org.jetbrains.kotlinx:kotlinx-coroutines-core:${LibsVersion.kotlinCoroutines}"
        const val playServices =
            "org.jetbrains.kotlinx:kotlinx-coroutines-play-services:${LibsVersion.kotlinCoroutines}"
    }

    object Firebase {
        const val core = "com.google.firebase:firebase-core:16.0.4"
        const val firestoreKtx = "com.google.firebase:firebase-firestore-ktx:20.2.0"
        const val auth = "com.google.firebase:firebase-auth:18.1.0"
        const val ui = "com.firebaseui:firebase-ui-auth:4.3.1"
        const val crashlytics = "com.google.firebase:firebase-crashlytics:17.0.0-beta01"
        const val analytics = "com.google.firebase:firebase-analytics:17.2.2"
        const val messaging = "com.google.firebase:firebase-messaging:20.1.0"
    }

    object OkHttp {
        const val client = "com.squareup.okhttp3:okhttp:${LibsVersion.okhttp}"
        const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${LibsVersion.okhttp}"
    }

    object Retrofit {
        const val retrofit = "com.squareup.retrofit2:retrofit:${LibsVersion.retrofit}"
        const val converter = "com.squareup.retrofit2:converter-moshi:${LibsVersion.retrofit}"
        const val coroutine = "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:0.9.2"
    }

    object Moshi {
        const val moshi = "com.squareup.moshi:moshi:${LibsVersion.moshi}"
        const val kotlin = "com.squareup.moshi:moshi-kotlin:${LibsVersion.moshi}"
    }

    const val liveEvent = "com.github.hadilq.liveevent:liveevent:1.0.1"

    object Hyperion {

        const val core = "com.willowtreeapps.hyperion:hyperion-core:${LibsVersion.hyperion}"
        const val attr = "com.willowtreeapps.hyperion:hyperion-attr:${LibsVersion.hyperion}"
        const val measurement =
            "com.willowtreeapps.hyperion:hyperion-measurement:${LibsVersion.hyperion}"
        const val disk = "com.willowtreeapps.hyperion:hyperion-disk:${LibsVersion.hyperion}"
        const val recorder = "com.willowtreeapps.hyperion:hyperion-recorder:${LibsVersion.hyperion}"
        const val phoenix = "com.willowtreeapps.hyperion:hyperion-phoenix:${LibsVersion.hyperion}"
        const val crash = "com.willowtreeapps.hyperion:hyperion-crash:${LibsVersion.hyperion}"
        const val preferences =
            "com.willowtreeapps.hyperion:hyperion-shared-preferences:${LibsVersion.hyperion}"
        const val counter = "com.willowtreeapps.hyperion:hyperion-geiger-counter:${LibsVersion.hyperion}"
        const val buildConfig =
            "com.willowtreeapps.hyperion:hyperion-build-config:${LibsVersion.hyperion}"
        const val plugin = "com.willowtreeapps.hyperion:hyperion-plugin:${LibsVersion.hyperion}"
        const val timber = "com.willowtreeapps.hyperion:hyperion-timber:${LibsVersion.hyperion}"

        const val http = "com.github.Commit451:Hyperion-Chuck:${LibsVersion.jitPack}"
    }

    object Ktlint {
        const val ktlint = "com.pinterest:ktlint:${LibsVersion.ktlint}"
    }

    object Epoxy {
        const val epoxy = "com.airbnb.android:epoxy:${LibsVersion.epoxy}"
        const val processer = "com.airbnb.android:epoxy-processor:${LibsVersion.epoxy}"
        const val databindingSupport = "com.airbnb.android:epoxy-databinding:${LibsVersion.epoxy}"
    }

    object Timber {
        const val timber = "com.jakewharton.timber:timber:${LibsVersion.timber}"
    }

    object Hilt {
        const val android = "com.google.dagger:hilt-android:${LibsVersion.hilt}"
        const val compiler = "com.google.dagger:hilt-compiler:${LibsVersion.hilt}"
    }

    object Takahirom {
        const val hyperionSimpleItem = "com.github.takahirom:Hyperion-Simple-Item:${LibsVersion.takahirom}"
    }
}
