package com.pihda.manages

import android.content.res.Resources
import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.*
import android.widget.TextView


class EmployeesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employees)

//        val textView: TextView = findViewById(R.id.name_text)
//        textView.text = Globals.restAddress
        val button: Button = findViewById(R.id.refresh)
        var tableLayout: TableLayout = findViewById(R.id.table_base);

        var tableRow = LayoutInflater.from(this).inflate(R.layout.table_item, null, false)
//        var firstName: TextView = tableRow.findViewById(R.id.first_name)

        button.setOnClickListener() {
            addRow(tableLayout, arrayOf("dsa", "asdfa", "dfsa", "asdf"))
        }

    }

    private fun addRow(base: TableLayout, columns: Array<String>) {
        var tableRow = LayoutInflater.from(this).inflate(R.layout.table_item, null, false)
        var firstName: TextView = tableRow.findViewById(R.id.first_name)
        var lastName: TextView = tableRow.findViewById(R.id.last_name)
        firstName.text = columns[1]
        lastName.text = columns[2]
        base.addView(tableRow)
    }

    //    override fun on() {
//
//    }
    val Int.dp: Int
        get() = (this * Resources.getSystem().displayMetrics.density + 0.5f).toInt()

    val Float.dp: Int
        get() = (this * Resources.getSystem().displayMetrics.density + 0.5f).toInt()
}