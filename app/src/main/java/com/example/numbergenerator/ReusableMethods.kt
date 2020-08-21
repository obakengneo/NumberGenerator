package com.example.numbergenerator

import kotlin.random.Random

class ReusableMethods {
    fun rand(start: Int, end: Int): Int {
        val rand = Random(System.nanoTime())
        return (start..end).random(rand)
    }

    fun duplicate (list: MutableList<Int>, number: Int) : Boolean {
        if (list.contains(number)) {
            return false
        }
        return true
    }
}