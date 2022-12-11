package com.fastcampus.springwebflux.book

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController //웹 플럭스에서도 동일하게 애노테이션을 사용할 수 있다.
class HelloController {
    @GetMapping
    fun hello() = "Hello WebFlux"
}