package com.example.mykotlinapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var textView1: TextView
    private lateinit var textView2: TextView
    private lateinit var textView3: TextView
    private lateinit var textView4: TextView
    private lateinit var textView5: TextView
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView1 = findViewById(R.id.textView1)
        textView2 = findViewById(R.id.textView2)
        textView3 = findViewById(R.id.textView3)
        textView4 = findViewById(R.id.textView4)
        textView5 = findViewById(R.id.textView5)
        button = findViewById(R.id.button)

        textView1.text = getString(R.string.text1)
        textView2.text = getString(R.string.text2)
        textView3.text = getString(R.string.text3)
        textView4.text = getString(R.string.text4)
        textView5.text = getString(R.string.text5)

        button.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java).apply {
                putExtra("text1", getString(R.string.text1))
                putExtra("text2", getString(R.string.text2))
                putExtra("text3", getString(R.string.text3))
                putExtra("text4", getString(R.string.text4))
                putExtra("text5", getString(R.string.text5))
                putExtra("booleanValue", true)
                putExtra("integerValue", 42)
                putExtra("floatValue", 3.14f)
            }
            startActivity(intent)
        }
    }
}
