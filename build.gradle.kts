plugins {
    base
    kotlin("jvm") version "1.4.10"
    kotlin("plugin.serialization") version "1.4.10"
    id("org.jetbrains.dokka") version "1.4.20"
    `java-library`
    `maven-publish`
}

object ProjectInfo {
    val version = "1.1"
    val artifactId = "iam-policy-dsl"
    val description = "A Kotlin DSL for declaring AWS IAM policy documents"

    val url = "https://github.com/lewis-od/iam-policy-dsl"
    val scm = "scm:git:$url"
}

group = "com.github.lewisod"
version = ProjectInfo.version

repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    implementation(kotlin("stdlib"))

    implementation("org.jetbrains.kotlinx:kotlinx-serialization-core:1.0.0-RC")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.4.2")
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.4.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.4.2")
    testImplementation("org.assertj:assertj-core:3.9.1")
    testImplementation("org.skyscreamer:jsonassert:1.5.0")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

java {
    withJavadocJar()
    withSourcesJar()
}
