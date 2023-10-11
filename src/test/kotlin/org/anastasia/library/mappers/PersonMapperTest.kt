/*
package org.anastasia.library.mappers
import org.anastasia.library.dto.AuthorDto
import org.anastasia.library.dto.BookDto
import org.anastasia.library.dto.PersonDto
import org.anastasia.library.model.Author
import org.anastasia.library.model.Book
import org.anastasia.library.model.Person
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PersonMapperTest {
    private val personMapper = PersonMapperImpl()

    @Test
    fun testToShortPersonDto() {
        val person = Person(1, "Анастасия", "Фирман")

        val shortPersonDto = personMapper.toShortPersonDto(person)

        assertEquals(person.id, shortPersonDto.id)
        assertEquals(person.firstName, shortPersonDto.firstName)
        assertEquals(person.lastName, shortPersonDto.lastName)
    }

    @Test
    fun testToPersonDto() {
        val author = Author(1, "Александр", "Дюма")
        val book = Book(1, "Граф Монте Кристо", author)
        val person = Person(1, "Анастасия", "Фирман", listOf(book))

        val personDto = personMapper.toPersonDto(person)

        assertEquals(person.id, personDto.id)
        assertEquals(person.firstName, personDto.firstName)
        assertEquals(person.lastName, personDto.lastName)
        assertEquals(person.books?.size, personDto.books.size)
        assertEquals(person.books?.get(0)?.id, personDto.books[0].id)
        assertEquals(person.books?.get(0)?.title, personDto.books[0].title)
    }

    @Test
    fun testToEntity() {
        val authorDto = AuthorDto(1, "Александр", "Дюма")
        val bookDto = BookDto(1, "Граф Монте Кристо", authorDto)
        val personDto = PersonDto(1, "Анастасия", "Фирман", listOf(bookDto))

        val person = personMapper.toEntity(personDto)

        assertEquals(personDto.id, person.id)
        assertEquals(personDto.firstName, person.firstName)
        assertEquals(personDto.lastName, person.lastName)
        assertEquals(personDto.books.size, person.books?.size)
        assertEquals(personDto.books[0].id, person.books?.get(0)?.id)
        assertEquals(personDto.books[0].title, person.books?.get(0)?.title)
    }
}*/
