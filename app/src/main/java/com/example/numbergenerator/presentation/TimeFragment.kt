package com.example.numbergenerator.presentation

import android.app.TimePickerDialog
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context.CLIPBOARD_SERVICE
import android.os.Bundle
import android.view.*
import android.widget.SeekBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.numbergenerator.R
import com.example.numbergenerator.util.Utility
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.util.*


class TimeFragment : Fragment() {

    lateinit var txtDateResults: TextView

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
        val btnGenerate = view.findViewById<FloatingActionButton>(R.id.btnGenerateTimes)

        txtDateResults = view.findViewById<TextView>(R.id.txtTimeResults)

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
                Utility().displayToast(this.requireContext(), "Please select both times!")
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
        var time: String

        val timePickerDialog = TimePickerDialog(
            this.requireContext(),
            { _, hourOfDay, minutes ->
                time = "${convertZero(hourOfDay)}:${convertZero(minutes)}"
                txtView.text = time
            }, 0, 0, true
        )
        timePickerDialog.show()
    }

    private fun generateRandomTimes(fromTime: String, toTime: String): String {
        try {
            val time1 = LocalTime.of(
                Utility().splitStringIntoList(fromTime, ':')[0].toInt(),
                Utility().splitStringIntoList(fromTime, ':')[1].toInt()
            )
            val time2 = LocalTime.of(
                Utility().splitStringIntoList(toTime, ':')[0].toInt(),
                Utility().splitStringIntoList(fromTime, ':')[1].toInt()
            )
            val secondOfDayTime1 = time1.toSecondOfDay()
            val secondOfDayTime2 = time2.toSecondOfDay()
            val random = Random()
            val randomSecondOfDay: Int =
                secondOfDayTime1 + random.nextInt(secondOfDayTime2 - secondOfDayTime1)
            val randomLocalTime = LocalTime.ofSecondOfDay(randomSecondOfDay.toLong())

            return randomLocalTime.format(DateTimeFormatter.ofPattern("HH:mm"))
        } catch (e: Exception) {
            Utility().displayToast(
                this.requireContext(),
                "Make sure Time from comes before Time to!"
            )
            return ""
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_copyto_clipboard, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.copy) {
            val myClipboard: ClipboardManager =
                activity?.getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
            val myClip = ClipData.newPlainText("text", txtDateResults.text)

            myClipboard.setPrimaryClip(myClip)

            Utility().displayToast(this.requireContext(), "Results copied to clipboard!")
        }
        return super.onOptionsItemSelected(item)
    }

    private fun convertZero(number: Int): String {
        if (number == 0) {
            return "00"
        } else if (number < 10) {
            return "0$number"
        }
        return number.toString()
    }
}