package com.appsfactory.pizzaapplication.common.utils

import com.appsfactory.pizzaapplication.common.utils.Constants.capitalise
import org.junit.Assert.*
import org.junit.Test

class ConstantsTest {

    @Test
    fun pass_lower_string_recieve_camelcase_string() {
        var str = "lower case"

        assertEquals("Lower Case", str.capitalise())

    }

}