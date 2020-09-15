package com.basgeekball.userservice.data

import com.basgeekball.userservice.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource
interface UserRepository : JpaRepository<User, Long> {
}