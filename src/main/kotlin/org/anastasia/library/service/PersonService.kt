package org.anastasia.library.service

import org.anastasia.library.model.Person

interface PersonService {

    fun save(person: Person): Person

    fun findById(id: Long): Person

    fun findAll(): List<Person>

    fun findAll(lastName: String): List<Person>

    fun deleteById(id: Long)

    fun update(id: Long, person: Person): Person

    fun setBookForPerson(personId: Long, bookId: Long): Person
}