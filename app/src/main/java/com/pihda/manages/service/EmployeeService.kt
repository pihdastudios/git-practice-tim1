package com.pihda.manages.service

import com.pihda.manages.entity.Employee
import retrofit2.Call
import retrofit2.http.*

interface EmployeeService {
    @GET("employees/{id}")
    fun getEmployee(@Path("id") id: String): Call<Employee>

    @GET("employees")
    fun getEmployees(): Call<List<Employee>>

    @POST("employees")
    fun createEmployee(@Body employee: Employee): Call<Employee>

    @DELETE("employees/{id}")
    fun deleteEmployee(@Path("id") id: String): Call<Employee>

    @PUT("employees")
    fun updateEmployee(@Body employee: Employee): Call<Employee>
}