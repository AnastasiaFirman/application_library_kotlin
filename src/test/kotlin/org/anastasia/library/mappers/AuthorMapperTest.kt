package org.anastasia.library.mappers

import org.anastasia.library.dto.AuthorDto
import org.anastasia.library.model.Author
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

class AuthorMapperTest {
    private val mapper = AuthorMapperImpl()

    @Test
    fun testToAuthorDto() {
        val author = Author(1, "Александр", "Дюма")

        val expectedDto = AuthorDto(1, "Александр", "Дюма")

        val actualDto = mapper.toAuthorDto(author)

        assertEquals(expectedDto, actualDto)
    }

    @Test
    fun testToEntity() {
        val authorDto = AuthorDto(1, "Александр", "Дюма")

        val expectedEntity = Author(1, "Александр", "Дюма")

        val actualEntity = mapper.toEntity(authorDto)

        assertEquals(expectedEntity, actualEntity)
    }
}