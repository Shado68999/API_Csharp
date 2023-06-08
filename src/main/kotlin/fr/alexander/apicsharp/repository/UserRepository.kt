package fr.alexander.apicsharp.repository

import fr.alexander.apicsharp.models.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, Long>
{
    fun findByEmailAndPassword(email: String, password: String): User?
}