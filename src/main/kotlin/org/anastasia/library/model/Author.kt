package org.anastasia.library.model

import org.hibernate.annotations.DynamicUpdate
import javax.persistence.*

@Entity
@Table(name = "author")
@DynamicUpdate
data class Author(
    @Id
    @GeneratedValue(generator = "author_id_seq")
    var id: Long = 0,
    @Column(name = "first_name")
    var firstName: String = "",
    @Column(name = "last_name")
    var lastName: String = "",
    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY, cascade = [CascadeType.PERSIST, CascadeType.MERGE])
    var books: List<Book> = emptyList()
) {
    fun getFirstNameAndLastName(): String {
        return "$firstName$lastName"
    }
}