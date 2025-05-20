package com.example.todoapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ToDoAdapter(private val todos: List<String>, private val onDeleteClick: (Int) -> Unit) :
    RecyclerView.Adapter<ToDoAdapter.ToDoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_todo, parent, false)
        return ToDoViewHolder(view)
    }

    override fun onBindViewHolder(holder: ToDoViewHolder, position: Int) {
        holder.bind(todos[position], position)
    }

    override fun getItemCount() = todos.size

    inner class ToDoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textView = itemView.findViewById<TextView>(R.id.todoText)
        private val button = itemView.findViewById<Button>(R.id.deleteButton)

        fun bind(todo: String, position: Int) {
            textView.text = todo
            button.setOnClickListener {
                onDeleteClick(position)
            }
        }
    }
}