package com.thoughtworks.biblioteca.user

import com.thoughtworks.biblioteca.book.BookRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(@Autowired private val userRepository: UserRepository, @Autowired private val bookRepository: BookRepository) : UserService {

    override fun getSpecificUser(userId: Long): User? = userRepository.findOneById(userId)

    override fun loginUser(userName: String?, password: String?): User? {
        if (userName == null) return null
        val user = userRepository.findOneByName(userName)
        return loginUser(user, password)
    }

    override fun loginUser(userId: Long, password: String?): User? {
        val user = userRepository.findOneById(userId)
        return loginUser(user, password)
    }

    private fun loginUser(user: User?, password: String?): User? {
        if (user != null && password != null && user.login(password)) {
            return user
        }
        return null
    }


    override fun logOut(userId: Long): Boolean {
        val user = userRepository.findOneById(userId)
        if (user != null) {
            return user.logout()
        }
        return false
    }

    override fun checkOutBook(userId: Long, bookId: Long): Boolean {
        val book = bookRepository.findOneById(bookId)
        val user = userRepository.findOneById(userId)

        if (book != null && user != null && user.isLoggedIn()) {
            return user.checkoutBook(book)
        }
        return false
    }

    override fun returnBook(userId: Long, bookId: Long): Boolean {
        val book = bookRepository.findOneById(bookId)
        val user = userRepository.findOneById(userId)

        if (book != null && user != null && user.isLoggedIn()) {
            return user.returnBook(book)
        }
        return false
    }
}