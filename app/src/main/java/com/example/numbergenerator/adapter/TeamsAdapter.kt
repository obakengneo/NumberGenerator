package com.example.numbergenerator.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.numbergenerator.R
import com.example.numbergenerator.model.TeamsModel

class TeamsAdapter(var mCtx: Context, var resources: Int, var items: List<TeamsModel>) :
    ArrayAdapter<TeamsModel>(mCtx, resources, items) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater: LayoutInflater = LayoutInflater.from(mCtx)
        val view = layoutInflater.inflate(resources, null)

        val names: TextView = view.findViewById(R.id.txtTeamNames)
        val index: TextView = view.findViewById(R.id.txtTeam)

        val mItem: TeamsModel = items[position]
        val team = "Team " + mItem.index
        index.text = team

        val builder = StringBuilder()
        for (details in mItem.teamList) {
            builder.append(details + "\n")
        }
        names.text = builder.toString()

        return view
    }
}