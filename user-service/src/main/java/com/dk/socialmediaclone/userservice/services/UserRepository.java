package com.dk.socialmediaclone.userservice.services;

import com.dk.socialmediaclone.userservice.entity.User;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

}
