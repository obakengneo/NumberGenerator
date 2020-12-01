package com.example.numbergenerator.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.numbergenerator.R
import com.example.numbergenerator.model.Model
import com.example.numbergenerator.util.ReusableMethods

class NamesAdapter(var mCtx: Context, var resources: Int, var items: List<Model>) :
    ArrayAdapter<Model>(mCtx, resources, items) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater: LayoutInflater = LayoutInflater.from(mCtx)
        val view = layoutInflater.inflate(resources, null)

        val name: TextView = view.findViewById(R.id.txtName)
        val index: TextView = view.findViewById(R.id.txtIndex)
        val imgDelete: ImageView = view.findViewById(R.id.imgDelete)
        val reusableMethods = ReusableMethods()

        val mItem: Model = items[position]

        index.text = mItem.index
        name.text = mItem.nameOfPerson

        imgDelete.setOnClickListener {
            val names = reusableMethods.getArrayList("Names", mItem.activity)

            Toast.makeText(this.context, names!![position] + " deleted!", Toast.LENGTH_SHORT).show()
            names.removeAt(position)
            reusableMethods.saveArrayList(names, "Names", mItem.activity)

            remove(getItem(position))
            notifyDataSetChanged()
        }

        return view
    }
}