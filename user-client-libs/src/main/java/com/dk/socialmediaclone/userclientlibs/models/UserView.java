package com.dk.socialmediaclone.userclientlibs.models;


import java.util.UUID;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class UserView {

  private UUID id;
  private String name;

  public UserView(String name) {
    this.name = name;
  }
}
