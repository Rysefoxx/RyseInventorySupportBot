plugins {
    id("java")
    application
}

group = "io.github.rysefoxx"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("net.dv8tion:JDA:5.0.0-alpha.9")
    implementation("io.github.cdimascio:dotenv-java:2.2.4")

    compileOnly("org.projectlombok:lombok:1.18.24")
    annotationProcessor("org.projectlombok:lombok:1.18.24")
}

application {
    mainClass.set("io.github.rysefoxx.SupportBot")
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}