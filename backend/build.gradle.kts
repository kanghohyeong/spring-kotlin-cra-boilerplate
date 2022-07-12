import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.7.1"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("jvm") version "1.6.21"
    kotlin("plugin.spring") version "1.6.21"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

/// frontend build
val frontendDir = "$projectDir/../frontend"
val FRONT_BUILD_GROUP = "build front"

task<Exec>("installFrontendDependency") {
    group = FRONT_BUILD_GROUP
    workingDir(frontendDir)
    inputs.dir(frontendDir)

    commandLine("npm", "install")
}

task<Exec>("buildFrontend") {
    group = FRONT_BUILD_GROUP
    dependsOn("installFrontendDependency")
    workingDir(frontendDir)
    inputs.dir(frontendDir)

    commandLine("npm", "run-script", "build")
}

task<Copy>("copyFrontendBuildFiles") {
    group = FRONT_BUILD_GROUP
    dependsOn("buildFrontend")
    from("$frontendDir/build")
    into("$projectDir/src/main/resources/static")
}

tasks {
    withType<ProcessResources> {
        dependsOn("copyFrontendBuildFiles")
    }
}