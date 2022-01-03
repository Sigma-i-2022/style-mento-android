package com.sigmai.stylemento.global.util

import junit.framework.Assert.assertEquals
import org.junit.Test

internal class ValidationUtilTest {

    @Test
    fun validateEmailForValidCase() {
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
    fun validatePasswordForValidCase() {
        val validator = ValidationUtil()
        val password = "abcd1234"

        val result = validator.validatePassword(password)

        assertEquals(result, true)
    }

    @Test
    fun validatePasswordForInvalidCase1() {
        val validator = ValidationUtil()
        val password = "abcdefgh"

        val result = validator.validatePassword(password)

        assertEquals(result, false)
    }

    @Test
    fun validatePasswordForInvalidCase2() {
        val validator = ValidationUtil()
        val password = "12345678"

        val result = validator.validatePassword(password)

        assertEquals(result, false)
    }

    @Test
    fun validatePasswordForInvalidCase3() {
        val validator = ValidationUtil()
        val password = "a123456"

        val result = validator.validatePassword(password)

        assertEquals(result, false)
    }
}