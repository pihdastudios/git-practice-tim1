package com.pihda.manages

import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.TableLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.pihda.manages.entity.Employee
import com.pihda.manages.service.EmployeeService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory


class EmployeesActivity : AppCompatActivity() {
    lateinit var tableLayout: TableLayout
    private lateinit var service: EmployeeService
    //    lateinit var selectedRow: View
    lateinit var selectedRow: SelectedRow
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employees)
        tableLayout = findViewById(R.id.table_base)

        val retrofit = Retrofit.Builder()
            .baseUrl(Globals.restAddress + "/api/")
            .addConverterFactory(JacksonConverterFactory.create())
            .build()

        service = retrofit.create(EmployeeService::class.java)
        selectedRow = SelectedRow(null, false)
    }

    fun refreshButtonHandler(@Suppress("UNUSED_PARAMETER") view: View) {
        tableLayout.removeAllViews()
        val call = service.getEmployees()

        tableLayout.addView(LayoutInflater.from(this).inflate(R.layout.table_title, null, false))
        tableLayout.addView(LayoutInflater.from(this).inflate(R.layout.table_header, null, false))

        call.enqueue(object : Callback<List<Employee>> {
            override fun onResponse(call: Call<List<Employee>>, response: Response<List<Employee>>) {
                val employees = response.body()
                if (employees != null) {
                    for (employee in employees) {
                        addRow(tableLayout, employee)
                    }
                }

            }

            override fun onFailure(call: Call<List<Employee>>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }

    fun editButtonHandler(view: View) {
        if (view !== selectedRow.view) {
            // Remove highlight
            selectedRow.view?.setBackgroundColor(Color.parseColor("#F0F7F7"))

            selectedRow.view = view
            selectedRow.selected = true
            view.setBackgroundColor(Color.CYAN)
//            view.invalidate()
        } else if (view === selectedRow.view) {
            // Remove highlight
            if (selectedRow.selected) {
                selectedRow.selected = false
                view.setBackgroundColor(Color.parseColor("#F0F7F7"))
            } else {
                selectedRow.selected = true
                view.setBackgroundColor(Color.CYAN)
            }

        }

    }
    private fun addRow(base: TableLayout, columns: Employee) {
        val tableRow = LayoutInflater.from(this).inflate(R.layout.table_item, null, false)
        val id: TextView = tableRow.findViewById(R.id.id)
        val firstName: TextView = tableRow.findViewById(R.id.first_name)
        val lastName: TextView = tableRow.findViewById(R.id.last_name)
        val role: TextView = tableRow.findViewById(R.id.role)
        id.text = columns.id.toString()
        firstName.text = columns.firstName
        lastName.text = columns.lastName
        role.text = columns.role.toString()
        base.addView(tableRow)
    }

    data class SelectedRow(var view: View?, var selected: Boolean)
}