package org.anastasia.library.dto

data class BookDto(
    var id: Long,
    var title: String,
    var author: AuthorDto,
    var person: ShortPersonDto? = null
)