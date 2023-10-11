package org.anastasia.library.service

import org.anastasia.library.exception.BookNotFoundException
import org.anastasia.library.exception.UserNotFoundException
import org.anastasia.library.model.Person
import org.anastasia.library.repository.BookRepository
import org.anastasia.library.repository.PersonRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class PersonServiceImpl(private val personRepository: PersonRepository, private val bookRepository: BookRepository): PersonService {

    override fun save(person: Person): Person {
        TODO("Not yet implemented")
    }

    override fun findById(id: Long): Person {
        TODO("Not yet implemented")
    }

    override fun findAll(): List<Person> {
        TODO("Not yet implemented")
    }

    override fun findAll(lastName: String): List<Person> {
        TODO("Not yet implemented")
    }

    override fun deleteById(id: Long) {
        TODO("Not yet implemented")
    }

    override fun update(id: Long, person: Person): Person {
        TODO("Not yet implemented")
    }

    @Transactional
    override fun setBookForPerson(personId: Long, bookId: Long): Person {
        val foundPerson = personRepository.findById(personId).orElseThrow { UserNotFoundException() }
        val foundBook = bookRepository.findById(bookId).orElseThrow { BookNotFoundException() }
        foundBook.person = foundPerson
        return foundPerson
    }
}