package com.sigmai.stylemento.global.constant

enum class TagType {
    NULL,
    CASULAL,
    STREET,
    MODERN,
    FEMININE,
    DANDY,
    MINIMAL,
    MAXIMAL,
    CITY,
    AMERICANCASUAL,
    CLASSIC,
    STUDENT,
    OFFICE,
    DATE,
    BLINDDATE,
    TRAVEL,
    PARTY,
    COUPLE,
    GUEST,
    SPRING,
    SUMMER,
    AUTUMN,
    WINTER,
    RAIN;

    companion object {
        fun getStyleTagList() = listOf(
            CASULAL, STREET, MODERN, FEMININE, DANDY,
            MINIMAL, MAXIMAL, CITY, AMERICANCASUAL, CLASSIC
        )
        fun getSituationTagList() = listOf(
            STUDENT, OFFICE, DATE, BLINDDATE, TRAVEL,
            PARTY, COUPLE, GUEST
        )
        fun getWeatherTagList() = listOf(
            SPRING, SUMMER, AUTUMN, WINTER, RAIN
        )
    }
}