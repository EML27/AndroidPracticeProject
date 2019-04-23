package com.example.androidpracticeproject

import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.androidpracticeproject.dataBase.Operation
import kotlinx.android.synthetic.main.history_item.view.*
import java.text.SimpleDateFormat
import java.time.format.DateTimeFormatter
import java.util.*

class MyAdapter(val list: List<Operation>) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent?.context)
                .inflate(R.layout.history_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindViews(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindViews(operation: Operation) {
            with(itemView) {
                var format = "dd/MM/yyyy hh:mm"
                val formatter = SimpleDateFormat(format)
                tv_action.text = operation.name
                tv_debt_size.text = operation.cost.toString()
                tv_date.text = formatter.format(operation.date)
                if (!operation.isAddition)
                    tv_debt_size.setTextColor(Color.RED)
            }
        }
    }
}