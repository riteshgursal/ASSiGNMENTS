package com.example.loginapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    lateinit var nameInput: EditText
    lateinit var contactInput: EditText
    lateinit var emailInput: EditText
    lateinit var phoneInput: EditText
    lateinit var passwordInput: EditText
    lateinit var addressInput: EditText
    lateinit var submitBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize views
        nameInput = findViewById(R.id.name_input)
        emailInput = findViewById(R.id.email_input)
        phoneInput = findViewById(R.id.phone_input)
        passwordInput = findViewById(R.id.password_input)
        addressInput = findViewById(R.id.address_input)
        submitBtn = findViewById(R.id.submit_btn)

        submitBtn.setOnClickListener {
            val name = nameInput.text.toString().trim()
            val email = emailInput.text.toString().trim()
            val phone = phoneInput.text.toString().trim()
            val password = passwordInput.text.toString().trim()
            val address = addressInput.text.toString().trim()

            // Validate fields
            when {
                name.isEmpty() -> showToast("Name is required")
                email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches() -> showToast("Valid email is required")
                phone.isEmpty() || phone.length != 10 -> showToast("Phone number must be 10 digits")
                password.isEmpty() -> showToast("Password is required")
                address.isEmpty() -> showToast("Address is required")
                else -> {
                    // Log credentials for debugging
                    Log.i("Credentials", "Name: $name, Email: $email, Phone: $phone, Password: $password, Address: $address")

                    // Show success message
                    showToast("Account created")

                    // Redirect to MainActivity2
                    val intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)

                    // Optionally, finish this activity so the user cannot go back
                    finish()
                }
            }
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
