package com.example.numbergenerator.presentation

import android.app.DatePickerDialog
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import android.view.*
import android.widget.SeekBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.numbergenerator.R
import com.example.numbergenerator.util.Utility
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit
import java.util.*
import java.util.concurrent.ThreadLocalRandom


class DateFragment : Fragment() {
    private lateinit var txtDateResults: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.date_fragment, container, false)
        val edtDateFrom = view.findViewById<TextView>(R.id.edtChooseDateFrom)
        val edtDateTo = view.findViewById<TextView>(R.id.edtChooseDateTo)
        val progressOnBar = view.findViewById<TextView>(R.id.txtTimesCount)
        val seekBar = view.findViewById<SeekBar>(R.id.sBarTimesCount)
        val btnGenerate = view.findViewById<FloatingActionButton>(R.id.btnGenerateDate)
        txtDateResults = view.findViewById<TextView>(R.id.txtDateResults)

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
                Utility().displayToast(
                    this.requireContext(),
                    "Please select both dates!"
                )
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

                val myFormat = "dd/MM/yyyy" // mention the format you need
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
                Utility().splitStringIntoList(fromDate, '/')[2].toInt(),
                Utility().splitStringIntoList(fromDate, '/')[1].toInt(),
                Utility().splitStringIntoList(fromDate, '/')[0].toInt()
            )
            val to: LocalDate = LocalDate.of(
                Utility().splitStringIntoList(toDate, '/')[2].toInt(),
                Utility().splitStringIntoList(toDate, '/')[1].toInt(),
                Utility().splitStringIntoList(toDate, '/')[0].toInt()
            )
            val days: Long = from.until(to, ChronoUnit.DAYS)
            val randomDays: Long = ThreadLocalRandom.current().nextLong(days + 1)
            val randomDate: LocalDate = from.plusDays(randomDays)

            return randomDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
        } catch (e: Exception) {
            Utility().displayToast(
                this.requireContext(),
                "Make sure Date from comes before Date to!"
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
                activity?.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val myClip = ClipData.newPlainText("text", txtDateResults.text)

            myClipboard.setPrimaryClip(myClip)
            Utility().displayToast(this.requireContext(), "Results copied to clipboard!")
        }
        return super.onOptionsItemSelected(item)
    }
}