package com.example.voiceassistant.assistant

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.voiceassistant.R
import com.example.voiceassistant.data.Assistant

class AssistantAdapter: RecyclerView.Adapter<AssistantAdapter.ViewHolder>() {

    var data = listOf<Assistant>()

        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.assistant_item_layout, parent, false) as ConstraintLayout
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.assistantMessage.text = item.assistant_message
        holder.humanMessage.text = item.human_message
    }

    override fun getItemCount() = data.size

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        val assistantMessage: TextView = itemView.findViewById(R.id.assistant_message)
        val humanMessage: TextView = itemView.findViewById(R.id.human_message)

    }

}