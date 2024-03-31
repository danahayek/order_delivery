package com.example.myapplication

import MyAdapter
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import model.ListItem

class OthersActivity : AppCompatActivity() {
    private lateinit var recyler_others: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_others)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        recyler_others = findViewById(R.id.recycler_others)
        recyler_others.layoutManager = LinearLayoutManager(this)
        val itemList = listOf(
            ListItem("Status", "Delivering", "Total price", "6378 LE", "Date", "1/1/2020", "Order Details"),
            ListItem("Status", "Returned", "Total price", "400 LE", "Date", "1/1/2020", "Order Details"),
            ListItem("Status", "Delivering", "Total price", "46378 LE", "Date", "1/1/2020", "Order Details"),
            ListItem("Status", "Returned", "Total price", "400 LE", "Date", "1/1/2020", "Order Details"),
            ListItem("Status", "Delivering", "Total price", "6378 LE", "Date", "1/1/2020", "Order Details"),

            // Add more items here
        )

        val adapter = MyAdapter(itemList)
        recyler_others.adapter = adapter
    }
}