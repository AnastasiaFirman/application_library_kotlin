package org.anastasia.library.mappers

import org.anastasia.library.dto.BookDto
import org.anastasia.library.dto.BookDtoWithoutAuthor
import org.anastasia.library.dto.ShortBookDto
import org.anastasia.library.model.Book
import org.mapstruct.Mapper


@Mapper
interface BookMapper {
    fun toBookDto(book: Book): BookDto
    fun toShortBookDto(book: Book): ShortBookDto
    fun toEntity(shortBookDto: ShortBookDto): Book
    fun toEntity(bookDto: BookDto): Book
    fun toEntity(bookDtoWithoutAuthor: BookDtoWithoutAuthor): Book
}