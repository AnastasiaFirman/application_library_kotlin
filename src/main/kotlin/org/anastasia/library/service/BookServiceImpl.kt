package org.anastasia.library.service

import org.anastasia.library.dto.AuthorDto
import org.anastasia.library.dto.ShortBookDto
import org.anastasia.library.exception.BookNotFoundException
import org.anastasia.library.model.Author
import org.anastasia.library.model.Book
import org.anastasia.library.model.Person
import org.anastasia.library.repository.AuthorRepository
import org.anastasia.library.repository.BookRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class BookServiceImpl(private val bookRepository: BookRepository, private val authorRepository: AuthorRepository) :
    BookService {

    @Transactional
    override fun save(book: Book): Book {
        val author = book.author

        authorRepository.findByFirstNameAndLastNameIgnoreCase(author.firstName, author.lastName)
            .ifPresentOrElse({ book.author = it }, { authorRepository.save(author) })
        return bookRepository.save(book)
    }

    @Transactional
    override fun saveAll(books: List<Book>): List<Book> {
        val uniqueConstraintAuthorMap = HashMap<String, Author>()
        val authorsBatch = LinkedList<Author>()

        books.stream()
            .map(Book::author)
            .forEach { author -> uniqueConstraintAuthorMap[author.getFirstNameAndLastName()] = author }

        for (author in uniqueConstraintAuthorMap.values) {
            authorRepository.findByFirstNameAndLastNameIgnoreCase(author.firstName, author.lastName)
                .ifPresentOrElse(
                    { existedAuthor ->
                        uniqueConstraintAuthorMap[existedAuthor.getFirstNameAndLastName()]!!.id = existedAuthor.id
                    },
                    { authorsBatch.add(author) }
                )
        }

        authorRepository.saveAll(authorsBatch)

        books.forEach { book -> book.author = uniqueConstraintAuthorMap[book.author.getFirstNameAndLastName()]!! }

        return bookRepository.saveAll(books)
    }

    override fun findByTitle(title: String): List<Book> {
        val foundBook = bookRepository.findByTitleContainingIgnoreCase(title)
        if (foundBook.isEmpty()) {
            throw BookNotFoundException()
        }
        return foundBook.map { book ->
            Book(
                book.id, book.title, book.person?.let { Person(it.id, it.firstName, it.lastName) },
                Author(book.author.id, book.author.firstName, book.author.lastName)
            )
        }
    }

    override fun findAll(): List<ShortBookDto> {
        val books = bookRepository.findAll()
        return books.map { book ->
            ShortBookDto(
                book.id, book.title,
                AuthorDto(book.author.id, book.author.firstName, book.author.lastName)
            )
        }
    }

    override fun findById(id: Long): Book {
        return bookRepository.findById(id).orElseThrow {
            BookNotFoundException()
        }
    }

    override fun deleteById(id: Long) {
        bookRepository.deleteById(id)
    }

    @Transactional
    override fun untieBookFromPerson(bookId: Long) {
        val foundBook = bookRepository.findById(bookId).orElseThrow {
            BookNotFoundException()
        }
        foundBook.person = null
    }

    @Transactional
    override fun update(id: Long, book: Book): Book {
        val existingBook = bookRepository.findById(id).orElseThrow { BookNotFoundException() }
        existingBook.title = book.title
        return bookRepository.save(existingBook)
    }
}