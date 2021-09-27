package com.pihda.manages.service

import com.pihda.manages.Model.EmployeeModel
import retrofit2.Call
import retrofit2.http.GET

interface EmployeeService {
    @GET("api/employees")
    fun getEmployees(): Call<EmployeeModel>
}