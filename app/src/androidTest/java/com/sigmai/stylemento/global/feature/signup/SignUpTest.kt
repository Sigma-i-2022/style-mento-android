package com.sigmai.stylemento.global.feature.signup

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import com.sigmai.stylemento.R
import com.sigmai.stylemento.feature.main.MainActivity
import org.hamcrest.CoreMatchers.containsString
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class SignUpTest {
    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java)

    // 정확한 동작 시나리오
    @Test
    fun test() {
        onView(withText("이메일로 가입하기")).perform(click())
        Thread.sleep(1000)
        onView(withId(R.id.signup_edit_text)).perform(typeText("abc123@naver.com"))
        Espresso.pressBack()
        Thread.sleep(1000)
        onView(withId(R.id.button_in_email)).check(matches(withText("인증번호 받기"))).perform(click())
        onView(withId(R.id.signup_edit_text)).perform(typeText("abcd"))
        Espresso.pressBack()
        onView(withId(R.id.button_in_email)).check(matches(withText("인증하기"))).perform(click())
        onView(withId(R.id.signup_password_edit_text)).perform(typeText("abcd1234"))
        Espresso.pressBack()
        onView(withText("다음")).perform(click())
        onView(withId(R.id.signup_password_edit_text)).perform(typeText("abcd1234"))
        Espresso.pressBack()
        onView(withText("다음")).perform(click())
        onView(withText("로그인")).perform(click())
    }


}