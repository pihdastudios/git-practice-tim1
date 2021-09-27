package com.pihda.manages
import com.fasterxml.jackson.annotation.JsonProperty
class EmployeeModel {
    enum class Role {
        MANAGER, JANITOR, OFFICE_BOY, SECRETARY
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