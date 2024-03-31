package com.example.myapplication

import MyAdapter
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import model.ListItem

class NewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_new)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val recyclerView: RecyclerView = findViewById(R.id.recycler_new)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val itemList = listOf(
            ListItem("Status", "New", "Total price", "400 LE", "Date", "1/1/2020", "Order Details"),
            ListItem("Status", "New", "Total price", "400 LE", "Date", "1/1/2020", "Order Details"),
            ListItem("Status", "New", "Total price", "400 LE", "Date", "1/1/2020", "Order Details"),
            ListItem("Status", "New", "Total price", "400 LE", "Date", "1/1/2020", "Order Details"),
            ListItem("Status", "New", "Total price", "400 LE", "Date", "1/1/2020", "Order Details"),

            // Add more items here
        )

        val adapter = MyAdapter(itemList)
        recyclerView.adapter = adapter
    }
}