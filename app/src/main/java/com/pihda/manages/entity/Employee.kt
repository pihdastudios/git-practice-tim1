package com.pihda.manages.entity
import com.fasterxml.jackson.annotation.JsonProperty
class Employee {
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