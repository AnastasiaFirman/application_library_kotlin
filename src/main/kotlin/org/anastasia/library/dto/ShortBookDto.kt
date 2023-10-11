package org.anastasia.library.dto

data class ShortBookDto(
    var id: Long,
    var title: String,
    var author: AuthorDto
)