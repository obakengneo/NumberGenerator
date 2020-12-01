package com.example.numbergenerator.presentation

import android.app.TimePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.numbergenerator.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.time.LocalTime
import java.util.*


class TimeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.time_fragment, container, false)
        val edtTimeFrom = view.findViewById<TextView>(R.id.edtChooseTimeFrom)
        val edtTimeTo = view.findViewById<TextView>(R.id.edtChooseTimeTo)
        val progressOnBar = view.findViewById<TextView>(R.id.txtTimesCount)
        val seekBar = view.findViewById<SeekBar>(R.id.sBarTimesCount)
        val txtDateResults = view.findViewById<TextView>(R.id.txtTimeResults)
        val btnGenerate = view.findViewById<FloatingActionButton>(R.id.btnGenerateTimes)

        edtTimeFrom.setOnClickListener {
            setTimeToTextView(edtTimeFrom)
        }

        edtTimeTo.setOnClickListener {
            setTimeToTextView(edtTimeTo)
        }

        btnGenerate.setOnClickListener {
            if (edtTimeFrom.text.toString() != "" && edtTimeTo.text.toString() != "") {
                val builder = StringBuilder()

                for (i in 1..seekBar.progress) {
                    builder.append(
                        generateRandomTimes(
                            edtTimeFrom.text.toString(),
                            edtTimeTo.text.toString()
                        ) + "\n"
                    )
                }
                txtDateResults.text = builder.toString()
            } else {
                Toast.makeText(
                    this.requireContext(),
                    "Please select both times!",
                    Toast.LENGTH_LONG
                ).show()
            }
        }

        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
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

    private fun setTimeToTextView(txtView: TextView) {
        val timePickerDialog = TimePickerDialog(
            this.requireContext(),
            { _, hourOfDay, minutes ->
                txtView.text = "$hourOfDay:$minutes"
            }, 0, 0, true
        )
        timePickerDialog.show()
    }

    private fun generateRandomTimes(fromTime: String, toTime: String): String {
        val time1 = LocalTime.of(
            splitStringIntoList(fromTime)[0].toInt(),
            splitStringIntoList(fromTime)[1].toInt()
        )
        val time2 = LocalTime.of(
            splitStringIntoList(toTime)[0].toInt(),
            splitStringIntoList(fromTime)[1].toInt()
        )
        val secondOfDayTime1 = time1.toSecondOfDay()
        val secondOfDayTime2 = time2.toSecondOfDay()
        val random = Random()
        val randomSecondOfDay: Int =
            secondOfDayTime1 + random.nextInt(secondOfDayTime2 - secondOfDayTime1)
        val randomLocalTime = LocalTime.ofSecondOfDay(randomSecondOfDay.toLong())

        return randomLocalTime.toString()
    }

    private fun splitStringIntoList(str: String): List<String> {
        return str.split(":").map { it.trim() }
    }
}