package com.obakengneo.numbergenerator.util

import android.app.Activity
import android.content.Context
import android.preference.PreferenceManager
import android.widget.Toast
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.obakengneo.db.SharedPref
import com.obakengneo.numbergenerator.R
import com.obakengneo.numbergenerator.db.DataBaseHandler
import com.obakengneo.numbergenerator.model.Team
import java.lang.reflect.Type
import java.util.*
import kotlin.collections.ArrayList
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

    fun saveArrayList(list: MutableList<String?>?, key: String, activity: Activity) {
        val prefs = PreferenceManager.getDefaultSharedPreferences(activity)
        val editor = prefs.edit()
        val gson = Gson()
        val json = gson.toJson(list)

        editor.putString(key, json)
        editor.apply()
    }

    fun getArrayList(key: String, activity: Activity): MutableList<String?> {
        val prefs = PreferenceManager.getDefaultSharedPreferences(activity)
        val gson = Gson()
        val json = prefs.getString(key, null)
        val type: Type = object : TypeToken<MutableList<String?>?>() {}.type

        return if (json != null) {
            gson.fromJson(json, type)
        } else {
            ArrayList()
        }
    }

    fun displayToast(context: Context, message: String) {
        Toast.makeText(
            context,
            message,
            Toast.LENGTH_SHORT
        ).show()
    }

    fun setTheme(context: Context, activity: Activity): Boolean {
        val sharedPref = SharedPref(context)

        return if (sharedPref.loadNightModeState() == true) {
            activity.setTheme(R.style.LightTheme)
            true
        } else {
            activity.setTheme(R.style.AppTheme)
            false
        }
    }

    fun saveList(name: String, list: MutableList<String?>, activity: Activity) {
        val gson = Gson()
        val json = gson.toJson(list)

        DataBaseHandler(activity).insertTeam(Team(name, json))
    }

    fun getList(name: String, activity: Activity): MutableList<String?>? {
        val gson = Gson()
        val team = DataBaseHandler(activity).getList(name)
        var json = ""
        val list: MutableList<String?> = ArrayList()

        if (name != "") {
            for (i in 0..team.size) {
                if (team[i].name == name) {
                    json = team[i].teamList
                    break
                }
            }

            val type: Type = object : TypeToken<MutableList<String?>?>() {}.type
            return gson.fromJson(json, type)

        } else {
            if (team.size != 0) {
                for (i in team.indices) {
                    list.add(team[i].name)
                }
                return list
            }
        }
        return null
    }
}