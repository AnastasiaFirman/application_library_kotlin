package org.anastasia.library.mappers
import org.anastasia.library.dto.AuthorDto
import org.anastasia.library.dto.ShortBookDto
import org.anastasia.library.model.Author
import org.anastasia.library.model.Book
import org.anastasia.library.model.Person
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
class BookMapperTest {
    private val bookMapper = BookMapperImpl()

    @Test
    fun testToBookDto() {
        val author = Author(1, "Александр", "Дюма")
        val person = Person(1, "Анастасия", "Фирман")
        val book = Book(1, "Граф Монте Кристо", person, author)

        val bookDto = bookMapper.toBookDto(book)

        assertEquals(book.id, bookDto.id)
        assertEquals(book.title, bookDto.title)
        assertEquals(book.author?.id, bookDto.author.id)
        assertEquals(book.author?.firstName, bookDto.author.firstName)
        assertEquals(book.author?.lastName, bookDto.author.lastName)
    }

    @Test
    fun testToEntity() {
        val authorDto = AuthorDto(1, "John", "Doe")
        val shortBookDto = ShortBookDto(1, "Book Title", authorDto)

        val book = bookMapper.toEntity(shortBookDto)

        assertEquals(shortBookDto.id, book.id)
        assertEquals(shortBookDto.title, book.title)
        assertEquals(shortBookDto.author.id, book.author?.id)
        assertEquals(shortBookDto.author.firstName, book.author?.firstName)
        assertEquals(shortBookDto.author.lastName, book.author?.lastName)
    }
}