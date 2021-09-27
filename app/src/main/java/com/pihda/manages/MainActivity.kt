package com.pihda.manages

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button: Button = findViewById(R.id.address_next_btn)
        val textEdit : TextInputEditText = findViewById(R.id.address_text_edit)
        button.setOnClickListener() {
//            button.text = textEdit.text.toString()
            Globals.restAddress = textEdit.text.toString()
            val intent = Intent(this, EmployeesActivity::class.java)
            startActivity(intent)
        }
    }


}