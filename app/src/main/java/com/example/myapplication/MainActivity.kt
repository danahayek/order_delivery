package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.LoginActivity

class MainActivity : AppCompatActivity() {
    private val SPLASH_DISPLAY_LENGTH = 4000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // Assuming you have a layout file named activity_main.xml

        // Using a Handler to delay the transition
        Handler().postDelayed({
            // Start your main activity here
            val mainIntent = Intent(this, LoginActivity::class.java)
            startActivity(mainIntent)
            finish() // Close the splash activity
        }, SPLASH_DISPLAY_LENGTH.toLong())
    }
}
