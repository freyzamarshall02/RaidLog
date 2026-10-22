plugins {
    java
}

repositories {
    maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
    // Check docs.papermc.io for the exact Paper API version string for 26.2
    compileOnly("io.papermc.paper:paper-api:26.2.build.+")
}

java {
    // Use the Java version that Paper 26.2 requires
    toolchain.languageVersion.set(JavaLanguageVersion.of(25))
}
