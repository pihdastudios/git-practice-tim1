package com.pihda.manages.entity
import com.fasterxml.jackson.annotation.JsonProperty
class Employee {
    enum class Role(val value: Int) {
        MANAGER(0), JANITOR(1), OFFICE_BOY(2), SECRETARY(3);
        companion object {
            private val VALUES = values();
            fun getByValue(value: Int) = VALUES.firstOrNull { it.value == value }
        }
    }

    @JsonProperty("id")
    var id: Int = 0

    @JsonProperty("firstName")
    lateinit var firstName: String

    @JsonProperty("lastName")
    lateinit var lastName: String

    @JsonProperty("role")
    lateinit var role: Role

}