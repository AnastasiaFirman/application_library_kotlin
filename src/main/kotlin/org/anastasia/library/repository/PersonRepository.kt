package org.anastasia.library.repository

import org.anastasia.library.model.Person
import org.springframework.data.jpa.repository.EntityGraph
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import java.util.*

interface PersonRepository : JpaRepository<Person, Long> {

    @EntityGraph(attributePaths = ["books"])
    override fun findById(id: Long): Optional<Person>

    fun findAllByLastNameIgnoreCase(lastName: String): List<Person>
}