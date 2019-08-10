package com.dk.socialmediaclone.postservice.entity;

import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
public class Post {

  @Id
  @GeneratedValue
  private UUID id;
  private String description;
  private UUID userId;

  public Post(String description, UUID userId) {
    this.description = description;
    this.userId = userId;
  }
}
