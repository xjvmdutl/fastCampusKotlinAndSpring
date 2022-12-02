package com.fastcampus.springwebflux

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.RouterFunctions.route
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.router

@Configuration
class Router { // 클라이언트로부터 전달받을 요청을 해석하고, 핸들러로 전달
    //Configuration 과 Bean 에노테이션을 통해 빈으로 등록해야한다.
    @Bean
    fun helloRouter(handler: HelloHandler): RouterFunction<ServerResponse> =
        route()
            .GET("/", handler::sayHello)
            .build()

    @Bean
    fun userRouter(handler: UserHandler): RouterFunction<ServerResponse> =
        /*
        route()
            .GET("/users/{id}", handler::getUser) //중복되는 경로는 중첩라우터를 사용해서 매핑할 수 있다.
            .GET("/users", handler::getAll)
        .build()
         */
        router {
            "/users".nest {
                GET("/{id}", handler::getUser)
                GET("/", handler::getAll)
            }
        }
}