package com.example.passwordauth

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.Calendar

class MainActivity : AppCompatActivity() {

    private lateinit var et_password: EditText
    private lateinit var b_enter: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        et_password = findViewById(R.id.et_password)
        b_enter = findViewById(R.id.b_enter)

        b_enter.setOnClickListener(View.OnClickListener {
            val input: String = et_password.text.toString()
            if (input.isNotEmpty()) {
                if (input == getCurrentPassword()) {
                    val intent = Intent(applicationContext, MainActivity3::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    Toast.makeText(this@MainActivity, "Wrong Password!", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this@MainActivity, "Enter Password!", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun getCurrentPassword(): String {
        val calendar = Calendar.getInstance()
        val curHours12 = calendar.get(Calendar.HOUR)
        val curMinutes = calendar.get(Calendar.MINUTE)
        return "$curHours12$curMinutes"
    }
}
