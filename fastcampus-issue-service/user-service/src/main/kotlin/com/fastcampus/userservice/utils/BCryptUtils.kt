package com.fastcampus.userservice.utils

import at.favre.lib.crypto.bcrypt.BCrypt

object BCryptUtils {
    fun hash(password: String) =
        BCrypt.withDefaults().hashToString(12, password.toCharArray())

    fun verity(password: String, hashedPassword: String) =
        BCrypt.verifyer().verify(password.toCharArray(), hashedPassword).verified //verified 가 반환하는것이 true면 일치, false면 불일치
}