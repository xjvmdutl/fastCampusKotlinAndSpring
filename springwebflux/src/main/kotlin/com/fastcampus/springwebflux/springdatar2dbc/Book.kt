package com.fastcampus.springwebflux.springdatar2dbc

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

@Table
data class Book(
    @Id
    val id: Long? = null,

    @Column
    val name: String,

    @Column
    val price: Int
) { //더티체크같은 기능을 사용하지 않기 떄문에 data 클래스로 만들어도 된다
}