package com.pihda.manages.entity


import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface EmployeeDBDao {

    @Insert
    fun insert(employee: Employee)

    @Update
    fun update(employee: Employee)

    @Query("SELECT * from employees WHERE id = :key")
    fun get(key: Long): Employee?

    @Query("DELETE FROM employees")
    fun clear()

    @Delete
    fun delete(employee: Employee)

    @Query("SELECT * FROM employees ORDER BY id DESC")
    fun getAll(): LiveData<List<Employee>>
}