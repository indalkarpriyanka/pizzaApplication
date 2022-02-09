package com.appsfactory.pizzaapplication.common.utils

object Constants {

    const val PIZZA_MODEL = "pizzaModel"

    fun String.capitalise(): String {
        val charArray: CharArray = this.toCharArray()
        var foundSpace = true
        for (i in charArray.indices) {
            if (Character.isLetter(charArray[i])) {
                if (foundSpace) {
                    charArray[i] = Character.toUpperCase(charArray[i])
                    foundSpace = false
                }
            } else {
                foundSpace = true
            }
        }
        return String(charArray)
    }
}