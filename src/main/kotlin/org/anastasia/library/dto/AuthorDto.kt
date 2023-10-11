package org.anastasia.library.dto

data class AuthorDto @JvmOverloads constructor(
    var id: Long = 0,
    var firstName: String = "",
    var lastName: String = ""
) {
   constructor(name: String) : this(0, name.split(" ")[0], name.split(" ")[1])
}