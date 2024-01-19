plugins {
  kotlin("jvm") version "1.5.21"
  application
  id("org.javamodularity.moduleplugin") version "1.8.12"
  id("org.openjfx.javafxplugin") version "0.0.13"
  id("org.beryx.jlink") version "2.25.0"
}

group = "com.example"
version = "1.0-SNAPSHOT"

repositories {
  mavenCentral()
}

val junitVersion = "5.9.2"

java.sourceCompatibility = JavaVersion.VERSION_17
java.targetCompatibility = JavaVersion.VERSION_17

tasks.withType<JavaCompile> {
  options.encoding = "UTF-8"
}

application {
  mainModule = "com.example.taskapp"
  mainClass.set("com.example.taskaspp.HelloApplication")
}

javafx {
  version = "17.0.6"
  modules = setOf("javafx.controls", "javafx.fxml")
}

dependencies {
  implementation(project(":TaskCore"))
  implementation("org.junit.jupiter:junit-jupiter-api:$junitVersion")
  testImplementation("org.junit.jupiter:junit-jupiter-engine:$junitVersion")
}

tasks.test {
  useJUnitPlatform()
}

//tasks.register<org.beryx.jlink.tasks.JLink>("jlink") {
//  imageZip.set(project.file("${buildDir}/distributions/app-${javafx.platform.classifier}.zip"))
//  options = listOf("--strip-debug", "--compress", "2", "--no-header-files", "--no-man-pages")
//  launcher {
//    name = "app"
//  }
//}
//
//tasks.register<org.beryx.jlink.tasks.JLinkZip>("jlinkZip") {
//  group = "distribution"
//}
