package com.pihda.manages

import android.content.res.Resources
import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.*

class EmployeesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employees)

//        val textView: TextView = findViewById(R.id.name_text)
//        textView.text = Globals.restAddress
        val button: Button = findViewById(R.id.refresh)
        button.setOnClickListener() {
            addRow(arrayOf("dsa", "asdfa", "dfsa", "asdf"))
        }

    }

    private fun addRow(columns: Array<String>) {
        var row: TableRow = TableRow(this).apply {
            setBackgroundColor(0xF0F7F7)
            setPadding(5.dp, 5.dp, 5.dp, 5.dp)
            for (column in columns) {
                addView(TextView(this@EmployeesActivity).apply {
                    weightSum = 1f
                    width = WRAP_CONTENT
                    height = WRAP_CONTENT
                    text = column
                })
            }
        }
        val layout: TableLayout = findViewById(R.id.table_base)
        layout.post {
            kotlin.run {
                layout.addView(row)
                layout.invalidate()
                Log.d("asd", "dsf")

            }
        }


    }

    //    override fun on() {
//
//    }
    val Int.dp: Int
        get() = (this * Resources.getSystem().displayMetrics.density + 0.5f).toInt()

    val Float.dp: Int
        get() = (this * Resources.getSystem().displayMetrics.density + 0.5f).toInt()
}