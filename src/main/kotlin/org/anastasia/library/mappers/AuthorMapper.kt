package org.anastasia.library.mappers


import org.anastasia.library.dto.AuthorDto
import org.anastasia.library.model.Author
import org.mapstruct.Mapper

@Mapper
interface AuthorMapper {
    fun toAuthorDto(author: Author): AuthorDto
    fun toEntity(authorDto: AuthorDto): Author
}