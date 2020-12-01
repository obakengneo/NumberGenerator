package com.example.numbergenerator.presentation

import android.app.DatePickerDialog
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
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit
import java.util.*
import java.util.concurrent.ThreadLocalRandom


class DateFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.date_fragment, container, false)
        val edtDateFrom = view.findViewById<TextView>(R.id.edtChooseDateFrom)
        val edtDateTo = view.findViewById<TextView>(R.id.edtChooseDateTo)
        val txtDateResults = view.findViewById<TextView>(R.id.txtDateResults)
        val progressOnBar = view.findViewById<TextView>(R.id.txtTimesCount)
        val seekBar = view.findViewById<SeekBar>(R.id.sBarTimesCount)
        val btnGenerate = view.findViewById<FloatingActionButton>(R.id.btnGenerateDate)

        edtDateFrom.setOnClickListener {
            setDateToTextView(edtDateFrom)
        }

        edtDateTo.setOnClickListener {
            setDateToTextView(edtDateTo)
        }

        btnGenerate.setOnClickListener {
            if (edtDateFrom.text.toString() != "" && edtDateTo.text.toString() != "") {
                val builder = StringBuilder()

                for (i in 1..seekBar.progress) {
                    builder.append(
                        generateRandomDates(
                            edtDateFrom.text.toString(),
                            edtDateTo.text.toString()
                        ) + "\n"
                    )
                }
                txtDateResults.text = builder.toString()
            } else {
                Toast.makeText(
                    this.requireContext(),
                    "Please select both dates!",
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

    private fun setDateToTextView(txtDate: TextView) {
        val cal = Calendar.getInstance()
        val dateSetListener =
            DatePickerDialog.OnDateSetListener { _, year, monthOfYear, dayOfMonth ->
                cal.set(Calendar.YEAR, year)
                cal.set(Calendar.MONTH, monthOfYear)
                cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)

                val myFormat = "dd.MM.yyyy" // mention the format you need
                val sdf = SimpleDateFormat(myFormat, Locale.US)
                txtDate.text = sdf.format(cal.time)
            }
        DatePickerDialog(
            this.requireContext(), dateSetListener,
            cal.get(Calendar.YEAR),
            cal.get(Calendar.MONTH),
            cal.get(Calendar.DAY_OF_MONTH)
        ).show()
    }

    private fun generateRandomDates(fromDate: String, toDate: String): String {
        try {
            val from: LocalDate = LocalDate.of(
                splitStringIntoList(fromDate)[2].toInt(),
                splitStringIntoList(fromDate)[1].toInt(),
                splitStringIntoList(fromDate)[0].toInt()
            )
            val to: LocalDate = LocalDate.of(
                splitStringIntoList(toDate)[2].toInt(),
                splitStringIntoList(toDate)[1].toInt(),
                splitStringIntoList(toDate)[0].toInt()
            )
            val days: Long = from.until(to, ChronoUnit.DAYS)
            val randomDays: Long = ThreadLocalRandom.current().nextLong(days + 1)
            val randomDate: LocalDate = from.plusDays(randomDays)
            return randomDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
        } catch (e: Exception) {
            Toast.makeText(
                this.requireContext(),
                "Make sure Date from comes before Date to!",
                Toast.LENGTH_LONG
            ).show()
            return ""
        }
    }

    private fun splitStringIntoList(str: String): List<String> {
        return str.split(".").map { it.trim() }
    }
}