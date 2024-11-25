package com.example.mykotlinapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ThirdActivity : AppCompatActivity() {
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        textView = findViewById(R.id.textView)

        val finalData = intent.getStringExtra("finalData")
        textView.text = getString(R.string.final_text, finalData)
    }
}
