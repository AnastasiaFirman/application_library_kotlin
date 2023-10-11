package org.anastasia.library.controller

import org.anastasia.library.dto.BookDto
import org.anastasia.library.dto.BookDtoWithoutAuthor
import org.anastasia.library.dto.ShortBookDto
import org.anastasia.library.mappers.BookMapper
import org.anastasia.library.service.BookService
import org.springframework.web.bind.annotation.*

@RestController
class BookController(private val bookService: BookService, private val bookMapper: BookMapper) {

    @GetMapping("/api/v1/book/{id}")
    fun findById(@PathVariable id: Long): BookDto {
        return bookMapper.toBookDto(bookService.findById(id))
    }

    @GetMapping("/api/v1/book")
    fun findByTitle(@RequestParam title: String): List<BookDto> {
        val books = bookService.findByTitle(title)
        return books.map { book -> bookMapper.toBookDto(book) }
    }

    @GetMapping("api/v1/books")
    fun findAll(): List<ShortBookDto> {
        return bookService.findAll()
    }

    @PostMapping("/api/v1/book")
    fun addBook(@RequestBody shortBookDto: ShortBookDto): ShortBookDto {
        return bookMapper.toShortBookDto(bookService.save(bookMapper.toEntity(shortBookDto)))
    }

    @PostMapping("/api/v1/list_of_books")
    fun addListOfBooks(@RequestBody bookDtos: List<ShortBookDto>): List<ShortBookDto> {
        val booksEntity = bookDtos.map { bookMapper.toEntity(it) }
        val savedBooks = bookService.saveAll(booksEntity)
        return savedBooks.map { bookMapper.toShortBookDto(it) }
    }

    @DeleteMapping("/api/v1/book/{id}")
    fun deleteById(@PathVariable("id") id: Long) {
        bookService.deleteById(id)
    }

    @PutMapping("/api/v1/book/action/{bookId}")
    fun untieBookFromPerson(@PathVariable bookId: Long) {
        bookService.untieBookFromPerson(bookId)
    }

    @PatchMapping("/api/v1/book/{id}")
    fun updateBook(@PathVariable id: Long, @RequestBody book: BookDtoWithoutAuthor): BookDto {
        return bookMapper.toBookDto(bookService.update(id, bookMapper.toEntity(book)))
    }
}