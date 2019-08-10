package com.dk.socialmediaclone.userservice.entity;


import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter @Setter @NoArgsConstructor
public class User {

  @Id
  @GeneratedValue
  private UUID id;
  @Size(min = 2, message = "Name should be atleast 2 characters")
  private String name;

  public User(String name) {
    this.name = name;
  }
}
