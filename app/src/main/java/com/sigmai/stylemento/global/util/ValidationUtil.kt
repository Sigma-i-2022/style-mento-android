package com.sigmai.stylemento.global.util

import java.util.regex.Pattern

class ValidationUtil {
    fun validateEmail(email: String) : Boolean {
        val emailAddressPattern = Pattern.compile(
            "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                    "\\@" +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                    "(" +
                    "\\." +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                    ")+"
        )

        return emailAddressPattern.matcher(email).matches()
    }

    fun validatePassword(password: String) : Boolean {
        val passwordPattern = Pattern.compile(
            "^(?=.*[0-9])(?=.*[a-zA-Z])(?=\\S+\$).{8,}"
        )
        return passwordPattern.matcher(password).matches()
    }
}