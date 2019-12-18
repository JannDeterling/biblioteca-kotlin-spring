package com.thoughtworks.biblioteca.book

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/books")
@CrossOrigin(origins = ["http://localhost:3000"])
class BookController(private val bookService: BookService) {

    @GetMapping
    fun getAllAvailableBooks(): List<Book> {
        return bookService.getAllBooksAvailable()
    }

    @GetMapping("/findByTitle")
    fun getSpecificBookByName(@RequestParam("title") title: String): Book?{
        return bookService.getSpecificBook(title)
    }

    @GetMapping("/{bookId}")
    fun getSpecificBook(@PathVariable("bookId") bookId: Long): Book?{
        return bookService.getSpecificBook(bookId)
    }
}