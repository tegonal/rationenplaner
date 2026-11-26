import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl

plugins {
	kotlin("multiplatform") version "2.4.21"
}

group = "org.fibl.rationenplaner"
version = "0.1.0-SNAPSHOT"

repositories {
	mavenCentral()
}

kotlin {
	@OptIn(ExperimentalWasmDsl::class)
	wasmJs {
		binaries.executable()
		browser()
		generateTypeScriptDefinitions()
	}
}
