package com.thoughtworks.biblioteca.book

import com.thoughtworks.biblioteca.util.BasicRepository

interface BookRepository: BasicRepository<Long, Book> {
    fun findOneByTitle(title: String): Book?
}