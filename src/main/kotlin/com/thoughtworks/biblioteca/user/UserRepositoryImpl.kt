package com.thoughtworks.biblioteca.user

import org.springframework.stereotype.Repository

@Repository
class UserRepositoryImpl: UserRepository {

    private val users = arrayListOf(
            User(0, "admin", "admin"),
            User(1, "jann", "123")
    )


    override fun findAll(): List<User> = users

    override fun findOneById(id: Long): User? = users.firstOrNull {user -> user.getId() == id}

    override fun findOneByName(userName: String): User? = users.firstOrNull { user -> user.username == userName }

    override fun save(entity: User) {
        if (users.none { user -> user.getId() == entity.getId() }){
            users.add(entity)
        }
    }

    override fun delete(entity: User) {
        users.remove(entity)
    }
}