package com.example.mykotlinapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.util.Log
import android.widget.Button
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    private lateinit var textView: TextView
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        textView = findViewById(R.id.textView)
        button = findViewById(R.id.button)

        val text1 = intent.getStringExtra("text1")
        val text2 = intent.getStringExtra("text2")
        val text3 = intent.getStringExtra("text3")
        val text4 = intent.getStringExtra("text4")
        val text5 = intent.getStringExtra("text5")
        val booleanValue = intent.getBooleanExtra("booleanValue", false)
        val integerValue = intent.getIntExtra("integerValue", 0)
        val floatValue = intent.getFloatExtra("floatValue", 0.0f)

        val displayText = "$text1, $text2, $text3, $text4, $text5\nBoolean: $booleanValue\nInteger: $integerValue\nFloat: $floatValue"
        textView.text = displayText

        Log.d("SecondActivity", displayText)

        button.setOnClickListener {
            val finalData = "Boolean: $booleanValue, Integer: $integerValue, Float: $floatValue"
            val intent = Intent(this, ThirdActivity::class.java).apply {
                putExtra("finalData", finalData)
            }
            startActivity(intent)
        }
    }
}
