import com.google.protobuf.gradle.id

plugins {
    java
    id("org.springframework.boot") version "3.3.0"
    id("io.spring.dependency-management") version "1.1.5"
    id("org.hibernate.orm") version "6.5.2.Final"
    id("org.graalvm.buildtools.native") version "0.10.2"
    id("com.google.protobuf") version "0.9.3"
}

protobuf{

    protoc { artifact = "com.google.protobuf:protoc:3.17.3" }
    plugins {
        id("grpc"){
            artifact = "io.grpc:protoc-gen-grpc-java:1.40.1"
        }
    }
    generateProtoTasks {
        all().forEach { task ->
            task.plugins { id("grpc") }
        }
    }
}

group = "com.kahindi"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_21
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

extra["springCloudVersion"] = "2023.0.1"

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-hateoas")
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.cloud:spring-cloud-starter-circuitbreaker-resilience4j")
    implementation("org.thymeleaf.extras:thymeleaf-extras-springsecurity6")
    // https://mvnrepository.com/artifact/org.springdoc/springdoc-openapi-starter-webmvc-ui
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.5.0")
    // https://mvnrepository.com/artifact/net.devh/grpc-server-spring-boot-starter
    implementation("net.devh:grpc-server-spring-boot-starter:3.1.0.RELEASE")
    // https://mvnrepository.com/artifact/io.grpc/grpc-netty-shaded
    implementation("io.grpc:grpc-netty-shaded:1.64.0")
    // https://mvnrepository.com/artifact/io.grpc/grpc-stub
    implementation("io.grpc:grpc-stub:1.64.0")
    // https://mvnrepository.com/artifact/javax.annotation/javax.annotation-api
    implementation("javax.annotation:javax.annotation-api:1.3.2")
    compileOnly("org.projectlombok:lombok")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    runtimeOnly("org.postgresql:postgresql")
    annotationProcessor("org.projectlombok:lombok")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.security:spring-security-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

dependencyManagement {
    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

hibernate {
    enhancement {
        enableAssociationManagement.set(true)
    }
}

