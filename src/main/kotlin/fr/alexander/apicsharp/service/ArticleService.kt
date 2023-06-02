package fr.alexander.apicsharp.service

import fr.alexander.apicsharp.models.Article
import java.util.Optional

interface ArticleService {
    fun createArticle(article: Article) : Article
    fun editArticle(id : Long, article: Article) : Article
    fun readArticle() : List<Article>
    fun getArticleById(id : Long) : Optional<Article>
    fun deleteArticle(id: Long) : String
}