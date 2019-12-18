package com.thoughtworks.biblioteca.user

import com.thoughtworks.biblioteca.book.Book

data class User(private val id: Long, val username: String, private val password: String) {

    private val checkedOutBooks = ArrayList<Book>()
    private var isLoggedIn = false

    fun login(password: String): Boolean {
        return if (this.password == password) {
            isLoggedIn = true
            true
        } else {
            false
        }
    }

    fun logout(): Boolean {
        return if (isLoggedIn) {
            isLoggedIn = false
            true
        } else {
            false
        }
    }

    fun checkoutBook(book: Book): Boolean {
        return if (book.checkoutBook()){
            checkedOutBooks.add(book)
            true
        } else {
            false
        }
    }

    fun returnBook(book: Book): Boolean {
        return if (book.returnBook()){
            checkedOutBooks.remove(book)
            true
        } else {
            false
        }
    }

    fun getCheckedOutBooks() = checkedOutBooks
    fun isLoggedIn() = isLoggedIn
    fun getId() = id
}
