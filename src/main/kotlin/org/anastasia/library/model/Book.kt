package org.anastasia.library.model

import org.hibernate.annotations.DynamicUpdate
import javax.persistence.*

@Entity
@NamedEntityGraph(name = "book.author", attributeNodes = [NamedAttributeNode("author")])
@Table(name = "book")
@DynamicUpdate
data class Book(
    @Id
    @GeneratedValue(generator = "book_id_seq")
    var id: Long = 0,
    @Column(name = "title")
    var title: String = "",
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    var person: Person? = null,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    var author: Author
) {
    constructor() : this(0, "", null, Author())
    constructor(id: Long, title: String, author: Author): this(id, title, null, author)
}