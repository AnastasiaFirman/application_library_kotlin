package org.anastasia.library.repository

import org.anastasia.library.model.Book
import org.springframework.data.jpa.repository.EntityGraph
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface BookRepository : JpaRepository<Book, Long> {

    @EntityGraph(attributePaths = ["author", "person"])
    override fun findById(id: Long): Optional<Book>

    @EntityGraph(attributePaths = ["author", "person"])
    fun findByTitleContainingIgnoreCase(title: String): List<Book>

    @EntityGraph(attributePaths = ["author", "person"])
    override fun findAll(): List<Book>
}