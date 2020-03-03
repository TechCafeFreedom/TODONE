plugins {
    `kotlin-dsl`
}

buildscript {
    repositories {
        jcenter()
    }
    dependencies {
        classpath("com.google.apis:google-api-services-androidpublisher:v3-rev46-1.25.0")
        classpath("com.google.api-client:google-api-client:1.28.0")
    }
}

repositories {
    jcenter()
}