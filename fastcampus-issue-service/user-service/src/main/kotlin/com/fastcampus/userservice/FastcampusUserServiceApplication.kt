package com.fastcampus.userservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@SpringBootApplication
@ConfigurationPropertiesScan //프로퍼티 스캔
class FastcampusUserServiceApplication {
}

fun main(args: Array<String>) {
    runApplication<FastcampusUserServiceApplication>(*args)
}