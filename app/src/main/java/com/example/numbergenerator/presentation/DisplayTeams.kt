package com.example.numbergenerator.presentation

import android.os.Bundle
import android.preference.PreferenceManager
import android.view.Menu
import android.view.MenuItem
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.numbergenerator.R
import com.example.numbergenerator.adapter.TeamsAdapter
import com.example.numbergenerator.model.TeamsModel
import com.example.numbergenerator.util.Utility

class DisplayTeams : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_teams)

        setUpToolbar()
        generateTeams()
    }

    private fun generateTeams() {
        val prefs = PreferenceManager.getDefaultSharedPreferences(this)
        val lstTeams = findViewById<ListView>(R.id.lstTeams)
        val names = Utility().getArrayList("Names", this)
        val list = mutableListOf<TeamsModel>()
        val num = names!!.size + 1
        val numberOfTeams = prefs.getInt("Teams", 1)
        val numberOfMembers = getNumberOfMembersInTeam(num, numberOfTeams)
        var index: Int

        if (names.size > 0) {
            for (i in 1..numberOfTeams) {
                val listOfTeam: MutableList<String> = ArrayList()

                for (x in 1..numberOfMembers) {
                    index = Utility().getRandom(names)

                    try {
                        if (index == names.size) {
                            index -= 1
                        }
                        listOfTeam.add(x.toString() + ". " + names[index])
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
        val toolbar: androidx.appcompat.widget.Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val actionBar = supportActionBar

        actionBar!!.title = "Teams"
        actionBar.setDisplayHomeAsUpEnabled(true)
        actionBar.setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_teams, menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.refresh) {
            generateTeams()
        }

        if (item.itemId == R.id.copy) {
            Utility().displayToast(this, "Copied to clipboard!")
        }
        return super.onOptionsItemSelected(item)
    }
}