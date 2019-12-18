package com.thoughtworks.biblioteca.user

import com.thoughtworks.biblioteca.util.BasicRepository


interface UserRepository: BasicRepository<Long, User> {
    fun findOneByName(userName: String): User?
}