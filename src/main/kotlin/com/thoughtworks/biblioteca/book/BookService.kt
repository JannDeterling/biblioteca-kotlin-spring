package com.thoughtworks.biblioteca.book

import java.time.Year

interface BookService {
    fun createBook(title: String, author: String, publishedYear: Year): Book
    fun getAllBooksAvailable(): List<Book>
    fun getSpecificBook(title: String): Book?
    fun getSpecificBook(id: Long): Book?
    fun checkOutBook(bookId: Long, userId: Long): Boolean
    fun returnBook(bookId: Long, userId: Long): Boolean
}