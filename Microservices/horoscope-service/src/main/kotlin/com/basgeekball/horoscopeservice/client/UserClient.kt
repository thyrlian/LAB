package com.basgeekball.horoscopeservice.client

import com.basgeekball.horoscopeservice.model.User
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.hateoas.CollectionModel
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@FeignClient("user-service")
interface UserClient {
    @RequestMapping(method = [RequestMethod.GET], value = ["/users"])
    fun getUsers(): CollectionModel<User>
}