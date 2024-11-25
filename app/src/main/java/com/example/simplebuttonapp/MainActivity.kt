package com.example.simplebuttonapp

import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var myTextView: TextView
    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var button3: Button

    // Sample texts for button 1
    private val sampleTexts = arrayOf(
        "Welcome to our app!",
        "Explore new features!",
        "Enjoy the experience!",
        "Stay connected!",
        "Have fun using this app!"
    )
    private var currentSampleIndex = 0

    // Initial text size and height
    private var currentTextSize = 24f // Default text size in sp
    private var currentHeight = 100 // Default height in pixels
    private val textSizeIncrement = 4f // Increment for text size
    private val heightIncrement = 20 // Increment for height

    // Click count for Button 2
    private var clickCount = 0
    private val maxClicks = 5 // Maximum clicks before reset

    // Alignment tracking
    private var isCenterAligned = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myTextView = findViewById(R.id.myTextView)
        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)

        button1.setOnClickListener {
            myTextView.text = sampleTexts[currentSampleIndex]
            currentSampleIndex = (currentSampleIndex + 1) % sampleTexts.size
        }

        button2.setOnClickListener {
            clickCount++

            if (clickCount <= maxClicks) {
                // Increase the text size and height
                currentTextSize += textSizeIncrement
                currentHeight += heightIncrement
            } else {
                // Reset to default values
                currentTextSize = 24f
                currentHeight = 100
                clickCount = 0 // Reset click count
            }

            // Update TextView properties
            myTextView.textSize = currentTextSize
            val params = myTextView.layoutParams
            params.height = currentHeight
            myTextView.layoutParams = params
        }

        button3.setOnClickListener {
            // Change text alignment between center and left
            isCenterAligned = !isCenterAligned
            myTextView.textAlignment = if (isCenterAligned) {
                View.TEXT_ALIGNMENT_CENTER // Center alignment
            } else {
                View.TEXT_ALIGNMENT_VIEW_START // Left alignment
            }
            // Set gravity for older APIs
            myTextView.gravity = if (isCenterAligned) {
                Gravity.CENTER // Center gravity
            } else {
                Gravity.START // Left gravity
            }
        }
    }
}
