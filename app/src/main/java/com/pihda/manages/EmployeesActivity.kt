package com.pihda.manages

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class EmployeesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employees)
        val textView: TextView = findViewById(R.id.name_text)
        textView.text = Globals.restAddress

    }
//    override fun on() {
//
//    }
}