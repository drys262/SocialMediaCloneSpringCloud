package com.dk.socialmediaclone.postservice.services;



import com.dk.socialmediaclone.userclientlibs.models.UserView;
import feign.FeignException;
import java.util.UUID;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("user-service")
@RibbonClient("user-service")
public interface UserServiceProxy {

  @GetMapping("/api/users/{id}")
  public UserView getUserById(@PathVariable UUID id) throws FeignException;

}