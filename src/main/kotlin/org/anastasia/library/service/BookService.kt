package org.anastasia.library.service

import org.anastasia.library.dto.ShortBookDto
import org.anastasia.library.model.Book

interface BookService {

    fun save(book: Book): Book

    fun saveAll(books: List<Book>): List<Book>

    fun findByTitle(title: String): List<Book>

    fun findAll(): List<ShortBookDto>

    fun findById(id: Long): Book

    fun deleteById(id: Long)

    fun untieBookFromPerson(bookId: Long)

    fun update(id: Long, book: Book): Book
}