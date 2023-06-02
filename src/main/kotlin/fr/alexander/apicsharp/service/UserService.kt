package fr.alexander.apicsharp.service

import fr.alexander.apicsharp.models.User
import java.util.*

interface UserService {
     fun createUser(user: User) : User
     fun readUser() : List<User>
     fun getUserById(id: Long): Optional<User>
     fun editUser(user: User, id : Long) : User
     fun deleteUser(id: Long) : String
}