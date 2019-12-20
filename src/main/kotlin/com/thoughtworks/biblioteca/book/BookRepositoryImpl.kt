package com.thoughtworks.biblioteca.book

import org.springframework.stereotype.Repository
import java.time.Year

@Repository
class BookRepositoryImpl : BookRepository {
    private val host = "http://localhost:8080/images"
    private val books = arrayListOf(
            Book(0, "Refactoring", "Martin Fowler", Year.of(1999), "", "$host/refactoring-cover.jpg"),
            Book(1, "Domain Driven Design", "Eric Evans", Year.of(2003), "", "$host/ddd-cover.jpg"),
            Book(2, "Clean Code", "Robert C. Martin", Year.of(2001), "", "$host/cc-cover.jpg"),
            Book(3, "Harry Potter 1", "Joanne K. Rowling", Year.of(2001), "", "$host/hr1-cover.jpeg"),
            Book(4, "Harry Potter 2", "Joanne K. Rowling", Year.of(2002), "", "$host/hr2-cover.jpeg"),
            Book(5, "Song of Fire and Ice 1", "George R. R. Martin", Year.of(2001), "", "$host/sif1-cover.jpg"),
            Book(6, "Song of Fire and Ice 2", "George R. R. Martin", Year.of(2001), "", "$host/sif2-cover.jpg"),
            Book(7, "Song of Fire and Ice 3", "George R. R. Martin", Year.of(2001), "")
    )


    override fun findAll(): List<Book> = books

    override fun findOneById(id: Long): Book? = books.firstOrNull { it.getId() == id }

    override fun findOneByTitle(title: String): Book? = books.firstOrNull { it.title == title }

    override fun save(entity: Book) {
        if (books.any { it.getId() == entity.getId() }) {
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