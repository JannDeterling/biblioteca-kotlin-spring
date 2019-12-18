package com.thoughtworks.biblioteca.user

interface UserService {
    fun getSpecificUser(userId: Long): User?
    fun loginUser(userId: Long, password: String?): User?
    fun loginUser(userName: String?, password: String?): User?
    fun logOut(userId: Long): Boolean
    fun checkOutBook(userId: Long, bookId: Long): Boolean
    fun returnBook(userId: Long, bookId: Long): Boolean
}