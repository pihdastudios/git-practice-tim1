package com.pihda.manages

import android.content.res.Resources
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.*
import com.pihda.manages.entity.Employee
import com.pihda.manages.service.EmployeeService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory


class EmployeesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employees)
        val button: Button = findViewById(R.id.refresh)
        val tableLayout: TableLayout = findViewById(R.id.table_base);

        var tableRow = LayoutInflater.from(this).inflate(R.layout.table_item, null, false)
        val retrofit = Retrofit.Builder()
            .baseUrl(Globals.restAddress + "/api/")
            .addConverterFactory(JacksonConverterFactory.create())
            .build()

        val service = retrofit.create(EmployeeService::class.java)

        button.setOnClickListener() {
            val call = service.getEmployees()
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


    val Int.dp: Int
        get() = (this * Resources.getSystem().displayMetrics.density + 0.5f).toInt()

    val Float.dp: Int
        get() = (this * Resources.getSystem().displayMetrics.density + 0.5f).toInt()
}