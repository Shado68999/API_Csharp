package fr.alexander.apicsharp.service

import fr.alexander.apicsharp.models.User
import fr.alexander.apicsharp.repository.UserRepository
import lombok.AllArgsConstructor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
@AllArgsConstructor
class UserServiceImpl(
        @Autowired
        val userRepository : UserRepository
) : UserService {

    override fun createUser(user: User): User = userRepository.save(user)

    override fun readUser(): List<User> = userRepository.findAll()

    override fun getUserById(id: Long): Optional<User> = userRepository.findById(id)

    override fun editUser(user: User, id: Long): User {
        return userRepository.findById(id)
                .map { u ->
                    u.name = user.name
                    u.email = user.email
                    u.password = user.password
                    u.confirmPass = user.confirmPass
                    u.conference = user.conference
                    u.role = user.role
                    u.origin = user.origin
                    return@map userRepository.save(u)
                }.orElseThrow { RuntimeException ("Utilisateur non trouvé !!") }
    }

    override fun deleteUser(id: Long): String {
        userRepository.deleteById(id)
        return "Utilisateur supprimer avec Succès !"
    }

}