package com.krai29.todoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var todoList = mutableListOf(Todo("Buy grocery",true),
                Todo("Clean room",false),
                Todo("Start workout",true))

        val adapter = TodoAdapter(todoList)
        rvToDos.layoutManager = LinearLayoutManager(this)
        rvToDos.adapter = adapter

        btnAddToDo.setOnClickListener {
            val title = etToDo.text.toString()
            val todo = Todo(title,false)
            todoList.add(todo)
            // adapter.notifyDataSetChanged()
            /* This will refresh the complete recycler view and
            hence not efficient if we know exactly the position where items are inserted
             */
            adapter.notifyItemInserted(todoList.size-1)
        }
    }

}

