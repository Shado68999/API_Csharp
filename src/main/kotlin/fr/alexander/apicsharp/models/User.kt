package fr.alexander.apicsharp.models

import jakarta.persistence.*
import lombok.AllArgsConstructor
import lombok.Getter
import lombok.NoArgsConstructor
import lombok.Setter
import org.jetbrains.annotations.NotNull
import org.springframework.context.annotation.DependsOn
import org.springframework.core.annotation.Order
import java.io.Serializable

@Entity
@Table(name = "USER")
@Order(2)
@DependsOn("CONFERENCE")
@Getter
@Setter
@AllArgsConstructor
data class User(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        internal val id : Long,
        @Column(length = 80)
        internal var name : String,
        @Column(length = 100)
        internal var email : String,
        @Column(length = 30)
        internal var password : String,
        @Column(length = 30)
        internal var confirmPass : String,
        @Column(length = 50)
        internal var role : String,
        @Column(length  =50)
        internal var origin : String,
        @ManyToOne
        @JoinColumn(name = "CONFERENCE_ID")
        internal var conference : Conference,
        @OneToMany(mappedBy = "user")
        internal var article: List<Article>
) : Serializable
