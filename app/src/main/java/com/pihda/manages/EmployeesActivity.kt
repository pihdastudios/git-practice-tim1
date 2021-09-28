package com.pihda.manages

import android.content.res.Resources
import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.LinearLayout
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.*

class EmployeesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employees)
//        val textView: TextView = findViewById(R.id.name_text)
//        textView.text = Globals.restAddress

    }

    private fun addRow() {
        var row: TableRow = TableRow(this).apply {
            setBackgroundColor(0xF0F7F7)
            setPadding(5.dp, 5.dp, 5.dp, 5.dp)
            Modifier.weight(1)
        }
        var we =  Modifier.weight(2.0f, true)
        val layout: TableLayout = findViewById(R.id.table_base)


    }
//    override fun on() {
//
//    }
    val Int.dp: Int
        get() = (this * Resources.getSystem().displayMetrics.density + 0.5f).toInt()

    val Float.dp: Int
        get() = (this * Resources.getSystem().displayMetrics.density + 0.5f).toInt()
}