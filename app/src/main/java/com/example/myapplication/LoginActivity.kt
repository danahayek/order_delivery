package com.example.myapplication

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginActivity : AppCompatActivity() {
    private lateinit var location: ImageView
    private lateinit var loginBtn: Button
    private lateinit var user_id_text: EditText
    private lateinit var password_text: EditText




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        enableEdgeToEdge()

        // Initialize views after setting content view
        location = findViewById(R.id.location)
        loginBtn = findViewById(R.id.button_log)
        user_id_text = findViewById(R.id.editTextText)
        password_text = findViewById(R.id.editTextTextPassword)

        loginBtn.setOnClickListener {
            val user_inputText = user_id_text.text.toString()
            val password_inputText = password_text.text.toString()

            if (user_inputText.isNotEmpty() && password_inputText.isNotEmpty()) {
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            } else {
                user_id_text.error = "Please enter user ID"
                password_text.error = "Please enter Password"
            }
        }

        // Apply edge-to-edge insets to the main layout
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { view, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Set onClickListener for login button to navigate to HomeActivity

        location.setOnClickListener {
            val builder = AlertDialog.Builder(this)

            // Set dialog title and message
            builder.setTitle("Choose Language")
            val customLayout = layoutInflater.inflate(R.layout.custom_dialog_layout, null)
            builder.setView(customLayout)
            // Set positive button and its click listener
            builder.setPositiveButton("Apply") { dialogInterface: DialogInterface, i: Int ->
                dialogInterface.dismiss()
            }

            // Create and show the AlertDialog
            val alertDialog: AlertDialog = builder.create()
            alertDialog.show() }


        // Set onClickListener for location ImageView to show AlertDialog
//        location.setOnClickListener {
//            // Create AlertDialog
//            val builder = AlertDialog.Builder(this)
//            val inflater = layoutInflater
//            val dialogView = inflater.inflate(R.layout.activity_home, null)
//            builder.setView(dialogView)
//
//            // Set message or customize the AlertDialog here
//            val messageTextView = dialogView.findViewById<TextView>(R.id.location)
//            messageTextView.text = "Your custom message"
//
//            // Add buttons or other views and their behavior here
//
//            // Create and show the AlertDialog
//            val alertDialog = builder.create()
//            alertDialog.show()
//        }
    }
}
