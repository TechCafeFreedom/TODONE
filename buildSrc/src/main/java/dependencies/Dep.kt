package dependencies

object Dep {
    private object LibsVersion {
        const val Kotlin = "1.5.10"
        const val KotlinCoroutines = "1.5.1"
        const val Room = "2.3.0"
        const val Navigation = "2.3.5"
        const val Okhttp = "4.9.0"
        const val Retrofit = "2.9.0"
        const val Moshi = "1.12.0"
        const val Hyperion = "0.9.31"
        const val Ktlint = "0.36.0"
        const val Epoxy = "3.9.0"
        const val Timber = "4.7.1"
        const val LiveData = "2.3.1"
        const val JitPack = "1.1.2"
        const val ViewPager2 = "1.0.0"
        const val Dokka = "0.9.17"
        const val Hilt = "2.37"
        const val Compose = "1.0.0-rc01"
        const val Takahirom = "0.5.0"
    }

    object GradlePlugin {
        const val android = "com.android.tools.build:gradle:4.2.2"
        const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${LibsVersion.Kotlin}"
        const val safeArgs =
            "androidx.navigation:navigation-safe-args-gradle-plugin:${LibsVersion.Navigation}"
        const val playServices = "com.google.gms:google-services:4.3.3"
        const val crashlytics = "com.google.firebase:firebase-crashlytics-gradle:2.0.0-beta01"
        const val dokka = "org.jetbrains.dokka:dokka-gradle-plugin:${LibsVersion.Dokka}"
        const val dokkaPlugin = "org.jetbrains.dokka"
        const val hilt = "com.google.dagger:hilt-android-gradle-plugin:${LibsVersion.Hilt}"
    }

    object Test {
        const val junit = "junit:junit:4.12"
        const val testRunner = "androidx.test:runner:1.3.0-alpha02"
        const val testRules = "androidx.test:rules:1.3.0-alpha02"
        const val testCoreKtx = "androidx.test:core-ktx:1.2.1-alpha02"
        const val androidJunit4Ktx = "androidx.test.ext:junit-ktx:1.1.2-alpha02"
        const val orchestrator = "androidx.test:orchestrator:1.3.0-alpha02"
        const val archCore = "androidx.arch.core:core-testing:2.1.0"
        const val liveDataTestingKtx = "com.jraska.livedata:testing-ktx:1.1.0"
        const val espressoCore = "androidx.test.espresso:espresso-core:3.3.0-alpha02"
        const val coroutinesTest =
            "org.jetbrains.kotlinx:kotlinx-coroutines-test:${LibsVersion.KotlinCoroutines}"
        const val kotlinTestAssertions = "io.kotlintest:kotlintest-assertions:3.1.10"
        const val testingKtx =
            "androidx.navigation:navigation-testing-ktx:${LibsVersion.Navigation}"
    }

    object AndroidX {
        const val appCompat = "androidx.appcompat:appcompat:1.3.0"
        const val recyclerView = "androidx.recyclerview:recyclerview:1.2.1"
        const val constraint = "androidx.constraintlayout:constraintlayout:2.0.4"
        const val design = "com.google.android.material:material:1.4.0"
        const val coreKtx = "androidx.core:core-ktx:1.6.0"
        const val preference = "androidx.preference:preference:1.1.1"
        const val activityKtx = "androidx.activity:activity-ktx:1.2.3"
        const val compose = "androidx.activity:activity-compose:1.3.0-alpha06"
        const val fragmentKtx = "androidx.fragment:fragment-ktx:1.3.5"

        const val lifecycleLiveData = "androidx.lifecycle:lifecycle-livedata:${LibsVersion.LiveData}"
        const val liveDataCoreKtx =
            "androidx.lifecycle:lifecycle-livedata-core-ktx:${LibsVersion.LiveData}"
        const val liveDataKtx = "androidx.lifecycle:lifecycle-livedata-ktx:${LibsVersion.LiveData}"

        const val viewPager2 = "androidx.viewpager2:viewpager2:${LibsVersion.ViewPager2}"

        object Room {
            const val compiler = "androidx.room:room-compiler:${LibsVersion.Room}"
            const val runtime = "androidx.room:room-runtime:${LibsVersion.Room}"
            const val coroutine = "androidx.room:room-ktx:${LibsVersion.Room}"
        }

        object Navigation {
            const val runtimeKtx = "androidx.navigation:navigation-runtime-ktx:${LibsVersion.Navigation}"
            const val fragmentKtx =
                "androidx.navigation:navigation-fragment-ktx:${LibsVersion.Navigation}"
            const val uiKtx = "androidx.navigation:navigation-ui-ktx:${LibsVersion.Navigation}"
        }

        object Compose {
            const val ui = "androidx.compose.ui:ui:${LibsVersion.Compose}"
            const val foundation = "androidx.compose.foundation:foundation:${LibsVersion.Compose}"
            const val material = "androidx.compose.material:material:${LibsVersion.Compose}"
            const val runtime = "androidx.compose.runtime:runtime:${LibsVersion.Compose}"
        }
    }

    object Kotlin {
        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${LibsVersion.Kotlin}"
        const val stdlibCommon = "org.jetbrains.kotlin:kotlin-stdlib-common:${LibsVersion.Kotlin}"
        const val coroutines =
            "org.jetbrains.kotlinx:kotlinx-coroutines-core:${LibsVersion.KotlinCoroutines}"
        const val playServices =
            "org.jetbrains.kotlinx:kotlinx-coroutines-play-services:${LibsVersion.KotlinCoroutines}"
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
        const val client = "com.squareup.okhttp3:okhttp:${LibsVersion.Okhttp}"
        const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${LibsVersion.Okhttp}"
    }

    object Retrofit {
        const val retrofit = "com.squareup.retrofit2:retrofit:${LibsVersion.Retrofit}"
        const val converter = "com.squareup.retrofit2:converter-moshi:${LibsVersion.Retrofit}"
        const val coroutine = "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:0.9.2"
    }

    object Moshi {
        const val moshi = "com.squareup.moshi:moshi:${LibsVersion.Moshi}"
        const val kotlin = "com.squareup.moshi:moshi-kotlin:${LibsVersion.Moshi}"
    }

    const val liveEvent = "com.github.hadilq.liveevent:liveevent:1.0.1"

    object Hyperion {

        const val core = "com.willowtreeapps.hyperion:hyperion-core:${LibsVersion.Hyperion}"
        const val attr = "com.willowtreeapps.hyperion:hyperion-attr:${LibsVersion.Hyperion}"
        const val measurement =
            "com.willowtreeapps.hyperion:hyperion-measurement:${LibsVersion.Hyperion}"
        const val disk = "com.willowtreeapps.hyperion:hyperion-disk:${LibsVersion.Hyperion}"
        const val recorder = "com.willowtreeapps.hyperion:hyperion-recorder:${LibsVersion.Hyperion}"
        const val phoenix = "com.willowtreeapps.hyperion:hyperion-phoenix:${LibsVersion.Hyperion}"
        const val crash = "com.willowtreeapps.hyperion:hyperion-crash:${LibsVersion.Hyperion}"
        const val preferences =
            "com.willowtreeapps.hyperion:hyperion-shared-preferences:${LibsVersion.Hyperion}"
        const val counter = "com.willowtreeapps.hyperion:hyperion-geiger-counter:${LibsVersion.Hyperion}"
        const val buildConfig =
            "com.willowtreeapps.hyperion:hyperion-build-config:${LibsVersion.Hyperion}"
        const val plugin = "com.willowtreeapps.hyperion:hyperion-plugin:${LibsVersion.Hyperion}"
        const val timber = "com.willowtreeapps.hyperion:hyperion-timber:${LibsVersion.Hyperion}"

        const val http = "com.github.Commit451:Hyperion-Chuck:${LibsVersion.JitPack}"
    }

    object Ktlint {
        const val ktlint = "com.pinterest:ktlint:${LibsVersion.Ktlint}"
    }

    object Epoxy {
        const val epoxy = "com.airbnb.android:epoxy:${LibsVersion.Epoxy}"
        const val processer = "com.airbnb.android:epoxy-processor:${LibsVersion.Epoxy}"
        const val databindingSupport = "com.airbnb.android:epoxy-databinding:${LibsVersion.Epoxy}"
    }

    object Timber {
        const val timber = "com.jakewharton.timber:timber:${LibsVersion.Timber}"
    }

    object Hilt {
        const val android = "com.google.dagger:hilt-android:${LibsVersion.Hilt}"
        const val compiler = "com.google.dagger:hilt-compiler:${LibsVersion.Hilt}"
    }

    object Takahirom {
        const val hyperionSimpleItem = "com.github.takahirom:Hyperion-Simple-Item:${LibsVersion.Takahirom}"
    }
}
