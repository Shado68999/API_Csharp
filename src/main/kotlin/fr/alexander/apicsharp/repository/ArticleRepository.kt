package fr.alexander.apicsharp.repository

import fr.alexander.apicsharp.models.Article
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ArticleRepository : JpaRepository<Article, Long> {
}