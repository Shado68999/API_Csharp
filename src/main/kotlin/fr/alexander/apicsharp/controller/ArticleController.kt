package fr.alexander.apicsharp.controller

import fr.alexander.apicsharp.models.Article
import fr.alexander.apicsharp.service.ArticleService
import lombok.AllArgsConstructor
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/ApiSharp/api/v1/Article")
class ArticleController(
       private val articleService : ArticleService
) {

    @PostMapping("/Article/create")
    fun create(@RequestBody article: Article) : Article = articleService.createArticle(article)

    @GetMapping("/Article/read")
    fun read() : List<Article> = articleService.readArticle()

    @GetMapping("/Article/get/{id}")
    fun getArticleById(@PathVariable id: Long): ResponseEntity<Article> {
        val article = articleService.getArticleById(id)
        return if (article.isPresent) {
            ResponseEntity.ok(article.get())
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @PutMapping("/Article/update/{id}")
    fun update(@PathVariable id : Long,@RequestBody article: Article) : Article = articleService.editArticle(id, article)

    @DeleteMapping("/Article/delete/{id}")
    fun delete(@PathVariable id : Long) : String = articleService.deleteArticle(id)
}