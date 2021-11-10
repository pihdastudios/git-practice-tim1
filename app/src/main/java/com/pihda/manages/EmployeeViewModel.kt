package com.pihda.manages


import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.pihda.manages.entity.Employee
import com.pihda.manages.entity.EmployeeDBDao

/**
 * ViewModel for SleepTrackerFragment.
 */
class EmployeeViewModel(val database: EmployeeDBDao, application: Application) : AndroidViewModel(application) {
    private val employees = database.getAll()

    private suspend fun insert(employee: Employee) {
        database.insert(employee)
    }

    private suspend fun update(employee: Employee) {
        database.update(employee)
    }

    suspend fun clear() {
        database.clear()
    }

    suspend fun delete(employee: Employee) {
        database.delete(employee)
    }
}
