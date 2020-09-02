package com.example.numbergenerator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class TeamsFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.teams_fragment, container, false)
        val lstNames = view.findViewById<ListView>(R.id.lstNames)
        val addNameToList = view.findViewById<Button>(R.id.btnAdd)
        val edtName = view.findViewById<EditText>(R.id.edtName)

        val list = mutableListOf<Model>()
        var count = 1

        setUpToolBar()

        addNameToList.setOnClickListener {
            val name = edtName.text.toString()

            if (name != "") {
                list.add(Model("$count.", name))
                count++
            } else {
                Toast.makeText(this.requireContext(), "Please insert a name!", Toast.LENGTH_SHORT)
                    .show()
            }

            edtName.text.clear()
            lstNames.adapter = NamesAdapter(this.requireContext(), R.layout.names_list, list)
        }
        return view
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)

        super.onCreate(savedInstanceState)
    }

    private fun setUpToolBar () {
        val actionBar = (activity as AppCompatActivity).supportActionBar

        actionBar!!.title = "Team Generator"
    }
}