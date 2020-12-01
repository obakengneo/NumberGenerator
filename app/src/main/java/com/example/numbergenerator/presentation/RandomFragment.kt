package com.example.numbergenerator.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.numbergenerator.R
import com.example.numbergenerator.util.ReusableMethods
import com.google.android.material.floatingactionbutton.FloatingActionButton


class RandomFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view: View = inflater.inflate(R.layout.random_fragment, container, false)
        setUpToolBar()

        val seek = view.findViewById<SeekBar>(R.id.sBarNumberCount)
        val progressOnBar = view.findViewById<TextView>(R.id.txtNumbersCount)
        val btnGetRange = view.findViewById<FloatingActionButton>(R.id.btnEnter)

        btnGetRange.setOnClickListener {
            generateNumbers(seek.progress, view)
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
        actionBar!!.title = "Numbers"
    }

    private fun generateNumbers(count: Int, view: View) {
        val reusableMethods = ReusableMethods()
        val result = view.findViewById<TextView>(R.id.txtValue)
        val edtFrom = view.findViewById<EditText>(R.id.edtFrom)
        val edtTo = view.findViewById<EditText>(R.id.edtTo)
        val allowDuplicates = view.findViewById<CheckBox>(R.id.chkAllowDuplicates)

        try {
            val firstValue: Int = edtFrom.text.toString().toInt()
            val secondValue: Int = edtTo.text.toString().toInt()
            val list: MutableList<Int> = ArrayList()
            var num: Int

            if (secondValue > firstValue) {

                for (i in 1..count) {
                    if (secondValue - firstValue > count) {
                        if (!allowDuplicates.isChecked) {
                            do {
                                num = reusableMethods.rand(firstValue, secondValue)
                            } while (!reusableMethods.duplicate(list, num))

                            list.add(num)
                        } else {
                            num = reusableMethods.rand(firstValue, secondValue)
                            list.add(num)
                        }

                        result.text = reusableMethods.getCommaSeperatedString(list)
                    } else {
                        Toast.makeText(
                            this.requireContext(),
                            "Please make sure the amount of numbers you need are within the range of $firstValue and $secondValue!",
                            Toast.LENGTH_LONG
                        ).show()
                        break
                    }
                }
            } else {
                Toast.makeText(
                    this.requireContext(),
                    "The Minimum range number cannot be greater than the Maximum range number!",
                    Toast.LENGTH_LONG
                ).show()
            }
        } catch (e: Exception) {
            Toast.makeText(
                this.requireContext(),
                "Please fill in a valid number in all the fields!",
                Toast.LENGTH_LONG
            ).show()
        }
    }
}