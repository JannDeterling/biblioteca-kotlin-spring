package com.thoughtworks.biblioteca.book

import java.time.Year

data class Book(private val id: Long,
                val title: String,
                val author: String,
                val publishedYear: Year,
                val description: String,
                val image: String = "no-image",
                private var isCheckedOut: Boolean = false) {

    fun checkoutBook(): Boolean {
        return if (isCheckedOut) {
            false
        } else {
            isCheckedOut = true
            true
        }
    }

    fun returnBook(): Boolean {
        return if (isCheckedOut) {
            isCheckedOut = false
            true
        } else {
            false
        }
    }

    fun getId() = id
    fun isCheckedOut(): Boolean = isCheckedOut
}