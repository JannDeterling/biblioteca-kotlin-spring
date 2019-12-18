package com.thoughtworks.biblioteca.book

import org.springframework.stereotype.Repository
import java.time.Year

@Repository
class BookRepositoryImpl : BookRepository {
    private val books = arrayListOf(
            Book(0, "Refactoring", "Martin Fowler", Year.of(1999), false),
            Book(1, "Domain Driven Design", "Eric Evans", Year.of(2003), false),
            Book(2, "Clean Code", "Robert C. Martin", Year.of(2001), false),
            Book(3, "Harry Potter 1", "Joanne K. Rowling", Year.of(2001), false),
            Book(4, "Lord of the Rings", "J. R. R. Tolkin", Year.of(2001), false),
            Book(5, "Song of Fire and Ice 1", "George R. R. Martin", Year.of(2001), false),
            Book(6, "Song of Fire and Ice 2", "George R. R. Martin", Year.of(2001), false)
    )


    override fun findAll(): List<Book> = books

    override fun findOneById(id: Long): Book? = books.firstOrNull { book -> book.getId() == id }

    override fun findOneByTitle(title: String): Book? = books.firstOrNull { book -> book.title == title }

    override fun save(entity: Book) {
        if (books.any { book -> book.getId() == entity.getId() }) {
            val oldVersion = findOneById(entity.getId())
            if (oldVersion != null) {
                delete(oldVersion)
            }
        }
        books.add(entity)
    }

    override fun delete(entity: Book) {
        books.remove(entity)
    }
}