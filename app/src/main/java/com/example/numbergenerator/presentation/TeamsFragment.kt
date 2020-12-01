package com.example.numbergenerator.presentation

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import android.widget.NumberPicker.OnValueChangeListener
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.numbergenerator.R
import com.example.numbergenerator.adapter.NamesAdapter
import com.example.numbergenerator.model.Model
import com.example.numbergenerator.util.ReusableMethods
import com.google.android.material.floatingactionbutton.FloatingActionButton


class TeamsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.teams_fragment, container, false)
        val addNameToList = view.findViewById<Button>(R.id.btnAdd)
        val edtName = view.findViewById<EditText>(R.id.edtName)
        val txtClearText = view.findViewById<TextView>(R.id.txtClearList)
        val btnGenerate = view.findViewById<FloatingActionButton>(R.id.btnGenerateTeams)
        val reusableMethods = ReusableMethods()
        var namesList = reusableMethods.getArrayList("Names", this.requireActivity())

        setUpToolBar()

        if (namesList != null) {
            populateListView(namesList, view)
        }

        addNameToList.setOnClickListener {
            val name = edtName.text.toString()

            try {
                if (name != "") {
                    namesList!!.add(name)
                    populateListView(namesList, view)
                    edtName.text.clear()
                } else {
                    Toast.makeText(this.requireContext(), "Please enter name!", Toast.LENGTH_SHORT)
                        .show()
                }
            } catch (e: Exception) {
                val list: MutableList<String?> = ArrayList()

                list.add(name)
                reusableMethods.saveArrayList(list, "Names", this.requireActivity())
                namesList = reusableMethods.getArrayList("Names", this.requireActivity())
                edtName.text.clear()
                populateListView(namesList, view)
            }
        }

        btnGenerate.setOnClickListener {
            try {
                if (namesList!!.size > 1) {
                    showNumberPickerDialog()
                } else {
                    Toast.makeText(
                        this.requireContext(),
                        "Please make sure you have more than one name in your list!",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            } catch (e: Exception) {
                Toast.makeText(this.requireContext(), "List is empty!", Toast.LENGTH_SHORT).show()
            }
        }

        txtClearText.setOnClickListener {
            namesList = ArrayList()
            populateListView(namesList, view)
        }

        return view
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        super.onCreate(savedInstanceState)
    }

    private fun setUpToolBar() {
        val actionBar = (activity as AppCompatActivity).supportActionBar
        actionBar!!.title = "Teams"
    }

    private fun showNumberPickerDialog() {
        val dialog = Dialog(this.requireContext())
        dialog.setContentView(R.layout.dialog)

        val btnSet = dialog.findViewById(R.id.button1) as Button
        val numberPicker = dialog.findViewById(R.id.numberPicker) as NumberPicker
        var numberOfTeams = 1

        dialog.show()

        numberPicker.maxValue = 10
        numberPicker.minValue = 1
        numberPicker.wrapSelectorWheel = false

        numberPicker.setOnValueChangedListener(OnValueChangeListener { _, _, newVal ->
            numberOfTeams = newVal
        })

        btnSet.setOnClickListener {
            val prefs = PreferenceManager.getDefaultSharedPreferences(this.requireContext())
            val editor = prefs.edit()
            val intent = Intent(context, DisplayTeams::class.java)

            editor.putInt("Teams", numberOfTeams)
            editor.apply()
            startActivity(intent)

            dialog.dismiss()
        }
    }

    private fun populateListView(namesList: MutableList<String?>?, view: View) {
        val list = mutableListOf<Model>()
        val lstNames = view.findViewById<ListView>(R.id.lstNames)
        val reusableMethods = ReusableMethods()
        var count = 1

        if (namesList != null) {
            for (x in namesList) {
                list.add(Model("$count.", x!!, this.requireActivity()))
                count++
            }
        }

        lstNames.adapter = NamesAdapter(this.requireContext(), R.layout.names_list, list)
        reusableMethods.saveArrayList(namesList, "Names", this.requireActivity())
    }
}


