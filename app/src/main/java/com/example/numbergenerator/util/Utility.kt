package com.example.numbergenerator.util

import android.app.Activity
import android.content.Context
import android.preference.PreferenceManager
import android.widget.Toast
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
import java.util.*
import kotlin.random.Random

class Utility {
    fun rand(start: Int, end: Int): Int {
        val rand = Random(System.nanoTime())
        return (start..end).random(rand)
    }

    fun duplicate(list: MutableList<Int>, number: Int): Boolean {
        if (list.contains(number)) {
            return false
        }
        return true
    }

    fun getCommaSeparatedString(list: MutableList<Int>): String {
        val joiner = StringJoiner(", ")
        for (item in list) {
            joiner.add(item.toString())
        }
        return joiner.toString()
    }

    fun splitStringIntoList(str: String, char: Char): List<String> {
        return str.split(char).map { it.trim() }
    }

    fun getRandomNumbersWithNoDuplicates(range: Int, length: Int): IntArray {
        if (length < range) {
            // this is where all the random numbers
            val randomNumbers = IntArray(length)

            // loop through all the random numbers to set them
            for (q in randomNumbers.indices) {

                // get the remaining possible numbers
                val remainingNumbers = range - q

                // get a new random number from the remainingNumbers
                var newRandSpot = (Math.random() * remainingNumbers).toInt()
                newRandSpot++

                // loop through all the possible numbers
                for (t in 1 until range + 1) {

                    // check to see if this number has already been taken
                    var taken = false
                    for (number in randomNumbers) {
                        if (t == number) {
                            taken = true
                            break
                        }
                    }

                    // if it hasnt been taken then remove one from the spots
                    if (!taken) {
                        newRandSpot--

                        // if we have gone though all the spots then set the value
                        if (newRandSpot == 0) {
                            randomNumbers[q] = t
                        }
                    }
                }
            }
            return randomNumbers
        }
        return IntArray(0)
    }

    fun getRandom(array: MutableList<String?>?): Int {
        return (0..array!!.size).random()
    }

    fun saveArrayList(list: MutableList<String?>?, key: String?, activity: Activity) {
        val prefs = PreferenceManager.getDefaultSharedPreferences(activity)
        val editor = prefs.edit()
        val gson = Gson()
        val json = gson.toJson(list)
        editor.putString(key, json)
        editor.apply()
    }

    fun getArrayList(key: String, activity: Activity): MutableList<String?>? {
        val prefs = PreferenceManager.getDefaultSharedPreferences(activity)
        val gson = Gson()
        val json = prefs.getString(key, null)
        val type: Type = object : TypeToken<MutableList<String?>?>() {}.type

        return gson.fromJson(json, type)
    }

    fun displayToast(context: Context, message: String) {
        Toast.makeText(
            context,
            message,
            Toast.LENGTH_LONG
        ).show()
    }
}