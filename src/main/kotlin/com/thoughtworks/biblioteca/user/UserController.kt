package com.thoughtworks.biblioteca.user

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = ["http://localhost:3000"], allowedHeaders = ["*"])
class UserController(@Autowired private val userService: UserService) {

    @GetMapping("/{userId}")
    fun getSpecificUser(@PathVariable("userId") userId: Long): User? = userService.getSpecificUser(userId)

    @PostMapping("/login")
    fun login(@RequestBody login: UserLogin?): User? {
       return userService.loginUser(login?.username, login?.password)
    }

    @PostMapping("/{userId}/logout")
    fun login(@PathVariable userId: Long): Boolean {
        return userService.logOut(userId)
    }

    @PostMapping("/{userId}/checkout-book/{bookId}")
    fun checkOutBookForUser(@PathVariable("userId") userId: Long, @PathVariable("bookId") bookId: Long): Boolean {
        return userService.checkOutBook(userId, bookId)
    }

    @PostMapping("/{userId}/return-book/{bookId}")
    fun returnBookForUser(@PathVariable("userId") userId: Long, @PathVariable("bookId") bookId: Long): Boolean {
        return userService.returnBook(userId, bookId)
    }

}

