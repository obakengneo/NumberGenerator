package com.obakengneo.numbergenerator.presentation

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.obakengneo.numbergenerator.R
import com.obakengneo.numbergenerator.adapter.TeamsAdapter
import com.obakengneo.numbergenerator.model.TeamsModel
import com.obakengneo.numbergenerator.util.Utility
import kotlinx.android.synthetic.main.teams_list.view.*
import kotlinx.android.synthetic.main.teams_menu.view.*

class DisplayTeams : AppCompatActivity() {

    lateinit var lstTeams: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Utility().setTheme(this, this)
        setContentView(R.layout.activity_display_teams)
        setUpToolbar()
        generateTeams()
    }

    private fun generateTeams() {
        val prefs = PreferenceManager.getDefaultSharedPreferences(this)
        val names = Utility().getArrayList("Names", this)
        val list = mutableListOf<TeamsModel>()
        val num = names.size + 1
        val numberOfTeams = prefs.getInt("Teams", 1)
        val numberOfMembers = getNumberOfMembersInTeam(num, numberOfTeams)
        var index: Int

        lstTeams = findViewById<ListView>(R.id.lstTeams)

        if (names.size > 0) {
            for (i in 1..numberOfTeams) {
                val listOfTeam: MutableList<String> = ArrayList()

                for (x in 1..numberOfMembers) {
                    index = Utility().getRandom(names)

                    try {
                        if (index == names.size) {
                            index -= 1
                        }

                        listOfTeam.add(names[index].toString())
                        names.remove(names[index])
                    } catch (e: Exception) {

                    }
                }

                list.add(TeamsModel(i.toString(), listOfTeam))
                lstTeams.adapter = TeamsAdapter(this, R.layout.teams_list, list)
            }
        }
    }

    private fun getNumberOfMembersInTeam(count: Int, numberOfTeams: Int): Int {
        return count / numberOfTeams
    }

    private fun setUpToolbar() {
        val prefs = PreferenceManager.getDefaultSharedPreferences(this)
        val toolbar: androidx.appcompat.widget.Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val actionBar = supportActionBar

        actionBar!!.title = prefs.getString("Header", "Teams") + " list"
        actionBar.setDisplayHomeAsUpEnabled(true)
        actionBar.setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_more, menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.teamMenu) {
            showBottomNavigationBar()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun showBottomNavigationBar() {
        val view: View = layoutInflater.inflate(R.layout.teams_menu, null)
        val bottomSheetDialog = BottomSheetDialog(this)

        bottomSheetDialog.setContentView(view)
        bottomSheetDialog.show()

        view.lRefresh.setOnClickListener {
            generateTeams()
            Utility().displayToast(this, "Teams refreshed!")
            bottomSheetDialog.dismiss()
        }

        view.lCopy.setOnClickListener {
            copyElementsToClipboard()
            bottomSheetDialog.dismiss()
        }
    }

    private fun copyElementsToClipboard() {
        val builder = StringBuilder()

        for (i in 0 until lstTeams.count) {
            val listOfNames = lstTeams[i].txtTeamNames.text.toString()
            val title = lstTeams[i].txtTeam.text.toString()

            builder.append(title + "\n\n" + listOfNames + "\n")
        }

        val myClipboard: ClipboardManager =
            getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val myClip = ClipData.newPlainText("text", builder.toString())

        myClipboard.setPrimaryClip(myClip)
        Utility().displayToast(this, "Lists of all teams copied to clipboard!")
    }
}