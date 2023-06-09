package fr.alexander.apicsharp.models

import jakarta.persistence.*
import lombok.AllArgsConstructor
import lombok.Getter
import lombok.Setter
import org.springframework.context.annotation.DependsOn
import org.springframework.core.annotation.Order
import java.io.Serializable


@Entity
@Order(3)
@Table(name = "ARTICLE")
@DependsOn("USER")
@Getter
@Setter
@AllArgsConstructor
data class Article(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        internal val id : Long,
        @Column(length = 100)
        internal var title : String,
        @Column(length = 180)
        internal var description : String,
        @Column(length = 50)
        internal var fichier : String,
        /*@ManyToOne
        @JoinColumn(name = "IdUser")
        internal var user : User*/
) : Serializable

