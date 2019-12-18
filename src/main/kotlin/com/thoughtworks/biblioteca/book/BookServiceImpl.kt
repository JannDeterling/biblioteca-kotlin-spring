package com.thoughtworks.biblioteca.book

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.Year
import kotlin.random.Random

@Service
class BookServiceImpl(@Autowired private val bookRepository: BookRepository) : BookService {

    override fun createBook(title: String, author: String, publishedYear: Year): Book {
        val book = Book(generateId(), title, author, publishedYear, false)
        bookRepository.save(book)
        return book
    }

    override fun getAllBooksAvailable(): List<Book> = bookRepository.findAll().filter { book -> !book.isCheckedOut() }


    override fun getSpecificBook(title: String): Book? = bookRepository.findOneByTitle(title)

    override fun getSpecificBook(id: Long): Book? = bookRepository.findOneById(id);

    override fun checkOutBook(bookId: Long, userId: Long): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun returnBook(bookId: Long, userId: Long): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun generateId() = Random(1000L).nextLong()
}