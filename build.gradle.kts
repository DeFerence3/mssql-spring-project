import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "3.2.0"
	id("io.spring.dependency-management") version "1.1.4"
	kotlin("jvm") version "1.9.20"
	kotlin("plugin.spring") version "1.9.20"
}

group = "com.play"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	runtimeOnly("com.microsoft.sqlserver:mssql-jdbc")
	testImplementation("org.springframework.boot:spring-boot-starter-test")


	implementation("org.apache.commons:commons-text:1.11.0")
	//implementation("com.fasterxml.jackson.core:jackson-databind:2.13.4.1")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-validation")
	implementation("com.google.code.gson:gson:2.9.0")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs += "-Xjsr305=strict"
		jvmTarget = "17"
	}
}
tasks.bootJar{
	duplicatesStrategy = DuplicatesStrategy.EXCLUDE
}
tasks.withType<Test> {
	useJUnitPlatform()
}
