package com.thoughtworks.biblioteca.book

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.time.Year

class BookTest {

    private val id = 1L
    private val title = "Example book title"
    private val author = "Example author"
    private val publishedYear = Year.now()

    @Test
    fun shouldCheckoutBook() {
        val book = Book(id, title, author, publishedYear, "")
        val expectedCheckout = true

        assertThat(book.checkoutBook()).isEqualTo(expectedCheckout)
        assertThat(book.isCheckedOut()).isEqualTo(expectedCheckout)
    }

    @Test
    fun shouldNotDoubleCheckoutBook() {
        val book = Book(id, title, author, publishedYear, "")
        val expectedCheckout = true
        val expectedSecondCheckout = false

        //first checkout
        assertThat(book.checkoutBook()).isEqualTo(expectedCheckout)
        assertThat(book.isCheckedOut()).isEqualTo(expectedCheckout)
        //second checkout
        assertThat(book.checkoutBook()).isEqualTo(expectedSecondCheckout)
        assertThat(book.isCheckedOut()).isEqualTo(expectedCheckout)
    }

    @Test
    fun shouldReturnBook() {
        val book = Book(id, title, author, publishedYear, "", isCheckedOut = true)
        val expectedReturn = true
        val expectedCheckout = false

        assertThat(book.returnBook()).isEqualTo(expectedReturn)
        assertThat(book.isCheckedOut()).isEqualTo(expectedCheckout)
    }

    @Test
    fun shouldNotDoubleReturnBook() {
        val book = Book(id, title, author, publishedYear,"", isCheckedOut = true)
        val expectedCheckout = false
        val expectedReturn = true
        val expectedSecondReturn = false

        //first return
        assertThat(book.returnBook()).isEqualTo(expectedReturn)
        assertThat(book.isCheckedOut()).isEqualTo(expectedCheckout)
        //second return
        assertThat(book.returnBook()).isEqualTo(expectedSecondReturn)
        assertThat(book.isCheckedOut()).isEqualTo(expectedCheckout)
    }

    @Test
    fun shouldCheckoutAndReturnBook() {
        val book = Book(id, title, author, publishedYear, "")

        val expectedCheckout = true
        val expectedReturn = true
        val expectedEndCheckout = false

        //checkout
        assertThat(book.checkoutBook()).isEqualTo(expectedCheckout)
        assertThat(book.isCheckedOut()).isEqualTo(expectedCheckout)
        //return
        assertThat(book.returnBook()).isEqualTo(expectedReturn)
        assertThat(book.isCheckedOut()).isEqualTo(expectedEndCheckout)
    }
}