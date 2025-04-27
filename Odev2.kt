package com.example.kotlininyo.nesne_tabanli_programlama

class Odev2 {
    fun celsiusToFahrenheit(celsius: Double): Double {
        return celsius * 1.8 + 32
    }
    fun rectanglePerimeter(shortSide: Double, longSide: Double): Double {
        return 2 * (shortSide + longSide)
    }

    fun factorial(number: Int): Long {
        var result = 1L
        for (i in 1..number) {
            result *= i
        }
        return result
    }

    fun countLetterA(word: String): Int {
        return word.count { it == 'a' || it == 'A' }
    }

    fun sumOfInteriorAngles(sides: Int): Int {
        return (sides - 2) * 180
    }

    fun calculateSalary(daysWorked: Int): Int {
        val hoursWorked = daysWorked * 8
        return if (hoursWorked <= 160) {
            hoursWorked * 10
        } else {
            (160 * 10) + ((hoursWorked - 160) * 20)
        }
    }

    fun calculateQuotaFee(quota: Int): Int {
        return if (quota <= 50) {
            100
        } else {
            100 + (quota - 50) * 4
        }
    }


}
