package org.anastasia.library.controller

import org.anastasia.library.dto.ShortPersonDto
import org.anastasia.library.mappers.PersonMapper
import org.anastasia.library.model.Person
import org.anastasia.library.service.PersonService
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class PersonController(private val personService: PersonService, private val personMapper: PersonMapper) {

    @PutMapping("/api/v1/person/{personId}/book/{bookId}")
    fun setBookForPerson(@PathVariable personId: Long, @PathVariable bookId: Long): ShortPersonDto {
        return personMapper.toShortPersonDto(personService.setBookForPerson(personId, bookId))
    }

}