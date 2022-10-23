package com.fastcampus.kotlinjava.gettersetter

import java.time.LocalDate

class Student {

    @JvmField
    var name: String? = null

    var birthDate: LocalDate? = null

    val age: Int = 10

    //var 키워드 setter 제거
    var grade: String? = null
        private set //클래스 내부에서만 setter를 사용할 수 있다

    fun changeGrade(grade: String) {
        this.grade = grade
    }
}