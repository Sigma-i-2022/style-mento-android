package com.sigmai.stylemento.global.util

import junit.framework.Assert.assertEquals
import org.junit.Test

internal class ValidationUtilTest {

    @Test
    fun validateEmailForValidatedCase() {
        val validator = ValidationUtil()
        val email = "example@gmail.com"

        val result = validator.validateEmail(email)

        assertEquals(result, true)
    }

    @Test
    fun validateEmailInvalidatedCase1() {
        val validator = ValidationUtil()
        val email = "@gmail.com"

        val result = validator.validateEmail(email)

        assertEquals(result, false)
    }

    @Test
    fun validateEmailInvalidatedCase2() {
        val validator = ValidationUtil()
        val email = "example@gmail"

        val result = validator.validateEmail(email)

        assertEquals(result, false)
    }

    @Test
    fun validatePassword() {
    }
}