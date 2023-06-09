package fr.alexander.apicsharp.service

import fr.alexander.apicsharp.models.Article
import fr.alexander.apicsharp.repository.ArticleRepository
import lombok.AllArgsConstructor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
@AllArgsConstructor
class ArticleServiceImpl(
        @Autowired
        val articleRepository: ArticleRepository
) : ArticleService {
    override fun createArticle(article: Article): Article = articleRepository.save(article)

    override fun editArticle(id: Long, article: Article): Article {
        return articleRepository.findById(id)
                .map {
                    it.title = article.title
                    it.description = article.description
                    it.fichier = article.fichier
                   // it.user = article.user
                    return@map articleRepository.save(it)
                }.orElseThrow { RuntimeException("Article non trouvé") }
    }

    override fun readArticle(): List<Article> = articleRepository.findAll()

    override fun getArticleById(id: Long): Optional<Article> = articleRepository.findById(id)

    override fun deleteArticle(id: Long): String {
        articleRepository.deleteById(id)
        val message = "Article supprimé avec succès"
        return message
    }
}