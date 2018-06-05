package rest

import javax.persistence.*

@Entity
data class BlogEntry(@Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Int? = null,
                     val headline: String? = null, val text: String? = null, val author: String? = null) {
    override fun toString(): String {
        return "BlogEntry(id=$id, headline=$headline, text=$text, author=$author)"
    }
}