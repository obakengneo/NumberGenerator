package com.obakengneo.numbergenerator.presentation

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import android.widget.NumberPicker.OnValueChangeListener
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.obakengneo.numbergenerator.R
import com.obakengneo.numbergenerator.adapter.ListAdapter
import com.obakengneo.numbergenerator.adapter.NamesAdapter
import com.obakengneo.numbergenerator.db.DataBaseHandler
import com.obakengneo.numbergenerator.model.Model
import com.obakengneo.numbergenerator.util.Utility
import kotlinx.android.synthetic.main.alert_dialog.view.*
import kotlinx.android.synthetic.main.confirm_delete_dialog.view.*
import kotlinx.android.synthetic.main.longpress_list.view.*
import kotlinx.android.synthetic.main.teams_fragment.view.*

class TeamsFragment : Fragment() {
    var update = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.teams_fragment, container, false)
        val edtName = view.findViewById<EditText>(R.id.edtName)

        setUpToolBar()
        populateElementsListView(view)

        view.btnAddList.setOnClickListener {
            visibility(view)
        }

        view.btnAdd.setOnClickListener {
            val name = edtName.text.toString()

            if (name != "") {
                val listOfNames = Utility().getArrayList("TempNames", this.requireActivity())
                listOfNames.add(name)

                Utility().saveArrayList(listOfNames, "TempNames", this.requireActivity())

                populateListView(view)
                edtName.text.clear()
            } else {
                Utility().displayToast(this.requireContext(), "Please enter name!")
            }
        }

        view.btnGenerateTeams.setOnClickListener {
            val listOfNames = Utility().getArrayList("TempNames", this.requireActivity())

            if (listOfNames.size > 1) {
                if (update == "") {
                    alertDialogDemo(view, listOfNames)
                } else {
                    Utility().saveList(update, listOfNames, this.requireActivity())
                    populateElementsListView(view)
                    Utility().displayToast(this.requireContext(), "$update list updated!")
                    update = ""
                    Utility().saveArrayList(ArrayList(), "TempNames", this.requireActivity())
                    populateListView(view)
                    visibility(view)
                }
            } else {
                Utility().displayToast(this.requireContext(), "Please add at least 2 names!")
            }
        }
        return view
    }

    private fun setUpToolBar() {
        val actionBar = (activity as AppCompatActivity).supportActionBar
        actionBar!!.title = "Lists"
        actionBar.setDisplayHomeAsUpEnabled(true)
        actionBar.setHomeAsUpIndicator(R.drawable.ic_baseline_menu_24)
    }

    private fun alertDialogDemo(layoutView: View, listOfNames: MutableList<String?>) {
        val layoutInflater = LayoutInflater.from(this.requireContext())
        val view: View = layoutInflater.inflate(R.layout.alert_dialog, null)
        val alertDialogBuilder = AlertDialog.Builder(this.requireContext())

        alertDialogBuilder.setView(view)

        val userInput = view.findViewById<View>(R.id.etUserInput) as EditText
        val alertDialog = alertDialogBuilder.create()
        var str = ""

        view.btnAddTeamName.setOnClickListener {
            val list = Utility().getList("", this.requireActivity())
            str = userInput.text.toString()

            try {
                if (!list!!.contains(str)) {
                    Utility().saveList(str, listOfNames, this.requireActivity())
                    populateElementsListView(layoutView)
                    alertDialog.dismiss()
                    visibility(layoutView)
                } else {
                    Utility().displayToast(this.requireContext(), "List '$str' already exists!")
                }
            } catch (e: Exception) {
                Utility().saveList(str, listOfNames, this.requireActivity())
                populateElementsListView(layoutView)
                alertDialog.dismiss()
                visibility(layoutView)
            }
        }

        alertDialog.show()
    }

    private fun showNumberPickerDialog(value: Int) {
        val dialog = Dialog(this.requireContext())
        dialog.setContentView(R.layout.dialog)

        val btnSet = dialog.findViewById(R.id.button1) as Button
        val numberPicker = dialog.findViewById(R.id.numberPicker) as NumberPicker

        var numberOfTeams = 1
        var maxValue = value

        dialog.show()

        if (maxValue > 10) {
            maxValue = 10
        }

        numberPicker.maxValue = maxValue
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

    private fun populateListView(view: View) {
        val listOfNames = Utility().getArrayList("TempNames", this.requireActivity())
        val list = mutableListOf<Model>()
        val lstNames = view.findViewById<ListView>(R.id.lstNames)
        var count = 1

        if (listOfNames.size != 0) {
            for (x in listOfNames) {
                list.add(Model("$count. ", x!!, this.requireActivity()))
                count++
            }
        }

        lstNames.adapter = NamesAdapter(this.requireContext(), R.layout.names_list, list)
    }

    private fun populateElementsListView(view: View) {
        val list = Utility().getList("", this.requireActivity())
        val listModel = mutableListOf<Model>()
        view.lstNames.adapter = null

        if (list != null) {
            for (i in list) {
                val elements = Utility().getList(i!!, this.requireActivity())
                listModel.add(
                    Model(
                        elements!!.size.toString() + " elements",
                        i,
                        this.requireActivity()
                    )
                )
            }
        }

        view.lstLists.adapter =
            ListAdapter(this.requireContext(), R.layout.elements_list, listModel)
        view.lstLists.setOnItemClickListener { _: AdapterView<*>, _: View, position: Int, _: Long ->
            if (list != null) {
                showBottomMenu(list, position, view)
            }
        }

        Utility().saveArrayList(ArrayList(), "TempNames", this.requireActivity())
    }

    private fun showBottomMenu(list: MutableList<String?>, position: Int, fragmentView: View) {
        val view: View = layoutInflater.inflate(R.layout.longpress_list, null)
        val bottomSheetDialog = BottomSheetDialog(this.requireContext())
        val selectedList = Utility().getList(list[position].toString(), this.requireActivity())
        val prefs = PreferenceManager.getDefaultSharedPreferences(activity)
        val editor = prefs.edit()

        bottomSheetDialog.setContentView(view)
        bottomSheetDialog.show()

        view.generateTeams.setOnClickListener {
            Utility().saveArrayList(selectedList, "Names", this.requireActivity())
            showNumberPickerDialog(selectedList!!.size)
            editor.putString("Header", list[position].toString())
            editor.apply()
            bottomSheetDialog.dismiss()
        }

        view.editList.setOnClickListener {
            update = list[position].toString()
            Utility().saveArrayList(selectedList, "TempNames", this.requireActivity())
            populateListView(fragmentView)
            bottomSheetDialog.dismiss()
            visibility(fragmentView)
        }

        view.deleteList.setOnClickListener {
            confirmDelete(list[position].toString(), fragmentView)
            bottomSheetDialog.dismiss()
        }
    }

    private fun visibility(view: View) {
        when (view.namesFrame.visibility) {
            View.GONE -> {
                view.namesFrame.visibility = View.VISIBLE
                view.listFrame.visibility = View.GONE
            }
            else -> {
                view.namesFrame.visibility = View.GONE
                view.listFrame.visibility = View.VISIBLE
            }
        }
    }

    private fun confirmDelete(name: String, fragmentView: View) {
        val view: View = layoutInflater.inflate(R.layout.confirm_delete_dialog, null)
        val alertDialog: AlertDialog =
            AlertDialog.Builder(this.requireContext()).setView(view).create()

        alertDialog.show()

        view.btnNo.setOnClickListener {
            alertDialog.dismiss()
        }

        view.btnContinue.setOnClickListener {
            Utility().displayToast(this.requireContext(), "List $name deleted!")
            DataBaseHandler(this.requireContext()).deleteList(name)
            populateElementsListView(fragmentView)
            alertDialog.dismiss()
        }
    }
}


