package com.example.numbergenerator.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.numbergenerator.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlin.random.Random

class PasswordFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.password_fragment, container, false)
        setUpToolBar()

        val seek = view.findViewById<SeekBar>(R.id.sBarLength)
        val txtPassword = view.findViewById<TextView>(R.id.txtPassword)
        val progressOnBar = view.findViewById<TextView>(R.id.txtProgressOnBar)
        val btnGenerate = view.findViewById<FloatingActionButton>(R.id.btnGeneratePassword)
        val chkUpperCase = view.findViewById<CheckBox>(R.id.chkUpperCase)
        val chkLowerCase = view.findViewById<CheckBox>(R.id.chkLowerCase)
        val chkDigits = view.findViewById<CheckBox>(R.id.chkDigits)
        val chkSymbols = view.findViewById<CheckBox>(R.id.chkSymbols)

        btnGenerate.setOnClickListener {
            when {
                !chkDigits.isChecked && !chkUpperCase.isChecked && !chkLowerCase.isChecked && !chkSymbols.isChecked -> {
                    Toast.makeText(
                        this.requireContext(),
                        "Please ensure at least one option is enabled!",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                else -> {
                    txtPassword.text = generateRandomPassword(
                        seek.progress,
                        chkUpperCase.isChecked,
                        chkLowerCase.isChecked,
                        chkDigits.isChecked,
                        chkSymbols.isChecked
                    )
                }
            }
        }

        seek.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seek: SeekBar, progress: Int, fromUser: Boolean) {
                progressOnBar.text = seek.progress.toString()
            }

            override fun onStartTrackingTouch(seek: SeekBar) {
                progressOnBar.text = seek.progress.toString()
            }

            override fun onStopTrackingTouch(seek: SeekBar) {
                progressOnBar.text = seek.progress.toString()
            }
        })

        return view
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        super.onCreate(savedInstanceState)
    }

    private fun setUpToolBar() {
        val actionBar = (activity as AppCompatActivity).supportActionBar
        actionBar!!.title = "Password"
    }

    private fun generateRandomPassword(
        max_length: Int,
        upperCase: Boolean,
        lowerCase: Boolean,
        numbers: Boolean,
        specialCharacters: Boolean
    ): String? {
        val upperCaseChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
        val lowerCaseChars = "abcdefghijklmnopqrstuvwxyz"
        val numberChars = "0123456789"
        val specialChars = "!@#$%^&*()_-+=<>?/{}~|"
        var allowedChars = ""
        val rn = Random(System.nanoTime())
        val sb = StringBuilder(max_length)

        if (upperCase) {
            allowedChars += upperCaseChars
            sb.append(upperCaseChars[rn.nextInt(upperCaseChars.length - 1)])
        }
        if (lowerCase) {
            allowedChars += lowerCaseChars
            sb.append(lowerCaseChars[rn.nextInt(lowerCaseChars.length - 1)])
        }
        if (numbers) {
            allowedChars += numberChars
            sb.append(numberChars[rn.nextInt(numberChars.length - 1)])
        }
        if (specialCharacters) {
            allowedChars += specialChars
            sb.append(specialChars[rn.nextInt(specialChars.length - 1)])
        }

        for (i in sb.length until max_length) {
            sb.append(allowedChars[rn.nextInt(allowedChars.length)])
        }

        return sb.toString()
    }
}