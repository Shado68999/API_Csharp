package fr.alexander.apicsharp.models

import jakarta.persistence.*
import lombok.*
import org.springframework.core.annotation.Order
import java.io.Serializable
import java.time.Instant

@Entity
@Order(1)
@Table(name = "CONFERENCE")
@Getter
@Setter
@AllArgsConstructor
data class Conference(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        internal val id : Long,
        @Column(length = 80)
        internal var name : String,
        @Column(length = 100)
        internal  var sigle : String,
        @Column(length = 200)
        internal var theme : String,
        @Column
        internal var dateSoumission: Instant,
        @Column
        internal var dateResultat: Instant,
        @Column
        internal var dateInscription: Instant,
        @Column
        internal var dateDeroulement: Instant,
        @OneToMany(mappedBy = "conference")
        internal var user: List<User>
) : Serializable {

        @PrePersist
        fun prePersist() {
                val now = Instant.now()
                dateSoumission = now
                dateResultat = now
                dateInscription = now
                dateDeroulement = now
        }
}

