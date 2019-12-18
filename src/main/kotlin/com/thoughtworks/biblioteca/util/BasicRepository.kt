package com.thoughtworks.biblioteca.util

interface BasicRepository<ID, T> {

    fun findAll(): List<T>
    fun findOneById(id: ID): T?
    fun save(entity: T)
    fun delete(entity: T)
}