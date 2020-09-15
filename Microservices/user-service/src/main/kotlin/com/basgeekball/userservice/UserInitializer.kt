package com.basgeekball.userservice

import com.basgeekball.userservice.client.RandomUserClient
import com.basgeekball.userservice.data.UserRepository
import com.basgeekball.userservice.entity.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import java.util.function.Consumer

@Component
class UserInitializer(private val userRepo: UserRepository) : CommandLineRunner {
    @Autowired
    private lateinit var randomUserClient: RandomUserClient

    override fun run(vararg args: String?) {
        val amountOfUsers = 10
        randomUserClient.getRandomUsers(amountOfUsers)?.results?.forEach {
            userRepo.save(User(0, "${it.name.first} ${it.name.last}", it.dob.date))
        }
        userRepo.findAll().forEach(Consumer { x: User? -> println(x) })
    }
}