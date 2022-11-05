import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.7.0"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    id("org.jetbrains.kotlin.jvm") version "1.6.21"
    id("java")
    //id("org.jetbrains.kotlin.plugin.allopen") version "1.6.21" //코틀린은 모두 상속이 안되기 때문에 해당플로그인으로 allopen 해주어야 한다
    kotlin("plugin.spring") version "1.6.21"
    //kotlin("plugin.noarg") version "1.6.21"
    kotlin("plugin.jpa") version "1.6.21"
}
/*
allOpen {
    annotations("org.springframework.boot.autoconfigure.SpringBootApplication"
    , "org.springframework.transaction.annotation.Transactional"
    )
    //항상 패키지를 지정해 주어야하는 단점이 있다.
}
 */
/*
noArg{
    annotation("javax.persistence.*")
    //엔티티는 noargConstruct 가 있어야 하는데 이를 생성해 준다.
    //항상 패키지를 지정해야하는 단점이 있다
}
 */


group = "com.fastcampus"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
    mavenCentral()
}

dependencies {
    compileOnly("org.projectlombok:lombok:1.18.24")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    runtimeOnly("com.h2database:h2")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}