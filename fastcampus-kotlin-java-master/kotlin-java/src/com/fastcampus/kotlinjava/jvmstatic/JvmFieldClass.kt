package com.fastcampus.kotlinjava.jvmstatic

class JvmFieldClass {

    companion object {
        @JvmField
        val id = 1234
        const val CODE = 1234
    }
}

object JvmFieldObject {
    @JvmField
    val name = "tony"
    const val FAMILY_NAME = "stark"
}

fun main() {
    val id = JvmFieldClass.id //클래스 지시자로 접근 가능
    val name = JvmFieldObject.name

}