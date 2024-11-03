package seg3x02.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import org.springframework.http.ResponseEntity

@RestController
class AuthorsController {

    @GetMapping("/authors/{id}")
    fun getAuthorById(@PathVariable id: Long): ResponseEntity<Author> {
        val author = Author(id, "Nom Exemple", "Biographie Exemple")
        
        return if (author != null) {
            ResponseEntity.ok(author)
        } else {
            ResponseEntity.notFound().build()
        }
    }
}

data class Author(val id: Long, val name: String, val bio: String)
