package com.pihda.manages.entity
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "employees")
class Employee {
    enum class Role(val value: Int) {
        MANAGER(0), JANITOR(1), OFFICE_BOY(2), SECRETARY(3);
        companion object {
            private val VALUES = values();
            fun getByValue(value: Int) = VALUES.firstOrNull { it.value == value }
        }
    }

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

    @ColumnInfo(name = "first_name")
    lateinit var firstName: String

    @ColumnInfo(name = "last_name")
    lateinit var lastName: String

    @ColumnInfo(name = "role")
    lateinit var role: Role

}