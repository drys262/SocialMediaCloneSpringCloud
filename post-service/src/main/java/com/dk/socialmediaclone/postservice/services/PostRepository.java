package com.dk.socialmediaclone.postservice.services;

import com.dk.socialmediaclone.postservice.entity.Post;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, UUID> {

  List<Post> findByUserId(UUID userId);


}
