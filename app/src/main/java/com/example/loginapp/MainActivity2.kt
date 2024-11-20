package com.example.loginapp

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        // Find the Register TextView
        val tvRegisterHere: TextView = findViewById(R.id.tvRegisterHere)

        // Set an OnClickListener on the Register TextView
        tvRegisterHere.setOnClickListener {
            // Redirect to MainActivity
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
