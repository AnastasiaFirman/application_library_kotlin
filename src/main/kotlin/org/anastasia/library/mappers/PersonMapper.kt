package org.anastasia.library.mappers

import org.anastasia.library.dto.PersonDto
import org.anastasia.library.dto.ShortPersonDto
import org.anastasia.library.model.Person
import org.mapstruct.Mapper

@Mapper
interface PersonMapper {
    fun toShortPersonDto(person: Person): ShortPersonDto
    fun toShortPersonDto(shortPersonDto: ShortPersonDto): ShortPersonDto
    fun toPersonDto(person: Person): PersonDto
    fun toEntity(personDto: PersonDto): Person
    fun toEntity(shortPersonDto: ShortPersonDto): Person
}