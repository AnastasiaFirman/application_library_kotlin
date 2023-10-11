package org.anastasia.library.dto

data class PersonDto(
    var id: Long,
    var firstName: String,
    var lastName: String,
    var books: List<ShortBookDto>? = null
)