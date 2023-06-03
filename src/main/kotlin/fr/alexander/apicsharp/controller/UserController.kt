package fr.alexander.apicsharp.controller

import fr.alexander.apicsharp.models.User
import fr.alexander.apicsharp.service.UserService
import lombok.AllArgsConstructor
import org.springframework.beans.factory.annotation.Autowired
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
@RequestMapping("/ApiSharp/api/v1")
class UserController(
       private val userService : UserService
) {
    @PostMapping("/User/create")
    fun create(@RequestBody user: User): User = userService.createUser(user)

    @GetMapping("/User/read")
    fun read(): List<User> = userService.readUser()

    @GetMapping("/User/get/{id}")
    fun getUserById(@PathVariable id: Long): ResponseEntity<User> {
        val user = userService.getUserById(id)
        return if (user.isPresent) {
            ResponseEntity.ok(user.get())
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @PutMapping("/User/update/{id}")
    fun update(@PathVariable id: Long,@RequestBody user: User): User = userService.editUser(user, id)

    @DeleteMapping("/User/delete/{id}")
    fun delete(@PathVariable id: Long) : String = userService.deleteUser(id)

    @PostMapping("/User/login")
    fun login(@RequestBody user: User): ResponseEntity<User> {
        val loggedInUser = userService.loginUser(user.email, user.password)
        return if (loggedInUser != null) {
            ResponseEntity.ok(loggedInUser)
        } else {
            ResponseEntity.notFound().build()
        }
    }

}
