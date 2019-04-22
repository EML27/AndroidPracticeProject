package com.example.androidpracticeproject

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.androidpracticeproject.dataBase.Operation

class MyAdapter(val list: List<Operation>) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent?.context)
                .inflate(R.layout.history_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder?.tvTitle?.text = list[position].name
        holder?.tvCost?.text = list[position].cost.toString()
        holder?.tvDate?.text = list[position].date.toString()
        //holder?.tvType?.text = list[position].type.toString()
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        var tvTitle: TextView? = null
        var tvCost: TextView? = null
        var tvDate: TextView? = null
        //var tvType: TextView? = null
    }
}