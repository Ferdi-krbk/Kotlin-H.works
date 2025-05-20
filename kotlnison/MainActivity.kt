package com.example.todoapp

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.content.SharedPreferences

class MainActivity : AppCompatActivity() {

    private lateinit var todoAdapter: ToDoAdapter
    private val todoList = mutableListOf<String>()
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPreferences = getSharedPreferences("todo_prefs", Context.MODE_PRIVATE)
        loadTodos()

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val addButton = findViewById<Button>(R.id.addButton)
        val inputText = findViewById<EditText>(R.id.inputText)

        todoAdapter = ToDoAdapter(todoList) { position ->
            deleteTodo(position)
        }

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = todoAdapter

        addButton.setOnClickListener {
            val todo = inputText.text.toString()
            if (todo.isNotEmpty()) {
                todoList.add(todo)
                todoAdapter.notifyItemInserted(todoList.size - 1)
                inputText.text.clear()
                saveTodos()
            }
        }
    }

    private fun saveTodos() {
        val editor = sharedPreferences.edit()
        editor.putInt("size", todoList.size)
        for ((index, item) in todoList.withIndex()) {
            editor.putString("todo_$index", item)
        }
        editor.apply()
    }

    private fun loadTodos() {
        val size = sharedPreferences.getInt("size", 0)
        for (i in 0 until size) {
            val todo = sharedPreferences.getString("todo_$i", null)
            if (todo != null) {
                todoList.add(todo)
            }
        }
    }

    private fun deleteTodo(position: Int) {
        todoList.removeAt(position)
        todoAdapter.notifyItemRemoved(position)
        saveTodos()
    }
}