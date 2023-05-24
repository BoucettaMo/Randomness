package com.example.coloringapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class Myadapter(private val context: Context,private val list:ArrayList<Int>,private val pivot:Int):RecyclerView.Adapter<Myadapter.ViewHolder>() {
    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val button=itemView.findViewById<Button>(R.id.button)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.item_view,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount()=28

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.button.setBackgroundColor(ContextCompat.getColor(context,list[10]))
        if (position==pivot) {
            holder.button.setBackgroundColor(ContextCompat.getColor(context,R.color.colorstep))
            
        }

    }

}
