package com.dk.socialmediaclone.postservice.controllers;


import com.dk.socialmediaclone.postservice.entity.Post;
import com.dk.socialmediaclone.postservice.services.PostRepository;
import com.dk.socialmediaclone.postservice.services.UserServiceProxy;
import com.dk.socialmediaclone.userclientlibs.models.UserView;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/posts")
public class PostController {

  @Autowired
  private PostRepository postRepository;

  @Autowired
  private UserServiceProxy userServiceProxy;

  @PostMapping
  public Post createPost(@RequestBody Post post) {
    UserView user = userServiceProxy.getUserById(post.getUserId());
    return postRepository.save(post);
  }

  @GetMapping("/{userId}")
  public List<Post> getAllPostByUserId(@PathVariable UUID userId) {
    UserView user = userServiceProxy.getUserById(userId);
    List<Post> posts = postRepository.findByUserId(userId);
    return posts;
  }

}
