package com.pihda.manages

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.pihda.manages.entity.Employee
import com.pihda.manages.service.EmployeeService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

class EditActivity : AppCompatActivity() {
    private lateinit var service: EmployeeService
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.employee_edit)
        val spinner: Spinner = findViewById(R.id.role)
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(
            this,
            R.array.roles_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner.adapter = adapter
        }

        val retrofit = Retrofit.Builder()
            .baseUrl(Globals.restAddress + "/api/")
            .addConverterFactory(JacksonConverterFactory.create())
            .build()

        service = retrofit.create(EmployeeService::class.java)

    }

    fun backButtonHandler(view: android.view.View) {
        val intent = Intent(this, EmployeesActivity::class.java)
        startActivity(intent)
    }

    fun saveButtonHandler(view: android.view.View) {
        val employee = Employee()
        employee.firstName = findViewById<EditText>(R.id.first_name).text.toString()
        employee.lastName = findViewById<EditText>(R.id.last_name).text.toString()
        employee.role = Employee.Role.getByValue(findViewById<Spinner>(R.id.role).selectedItemPosition)!!
//        employee.role = Employee.Role.getByValue(1)!!
        val call = service.createEmployee(employee)
        call.enqueue(object : Callback<Employee> {
            override fun onResponse(call: Call<Employee>, response: Response<Employee>) {
                Toast.makeText(this@EditActivity, "Saved!", Toast.LENGTH_SHORT).show()
                val intent = Intent(this@EditActivity, EmployeesActivity::class.java)
                startActivity(intent)
            }

            override fun onFailure(call: Call<Employee>, t: Throwable) {
                Toast.makeText(this@EditActivity, "Saving Failed", Toast.LENGTH_SHORT).show()
            }

        })
    }
}