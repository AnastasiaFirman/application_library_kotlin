package org.anastasia.library.repository

import org.anastasia.library.model.Author
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

interface AuthorRepository : JpaRepository<Author, Long> {

    fun findByFirstNameAndLastNameIgnoreCase(firstName: String, lastName: String): Optional<Author>
}