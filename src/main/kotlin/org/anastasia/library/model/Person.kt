package org.anastasia.library.model

import javax.persistence.*

@Entity
@Table(name = "person")
data class Person(
    @Id
    @GeneratedValue(generator = "person_id_seq")
    var id: Long = 0,
    @Column(name = "first_name")
    var firstName: String = "",
    @Column(name = "last_name")
    var lastName: String = "",
    @OneToMany(mappedBy = "person", fetch = FetchType.LAZY, cascade = [CascadeType.MERGE])
    var books: MutableList<Book>? = null
)