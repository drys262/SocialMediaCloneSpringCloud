package com.dk.socialmediaclone.postservice.exceptions;

import com.dk.socialmediaclone.userclientlibs.models.UserNotFoundException;
import feign.Response;
import feign.codec.ErrorDecoder;

public class CustomErrorDecoder implements ErrorDecoder {

  private final ErrorDecoder defaultErrorDecoder = new Default();
  @Override
  public Exception decode(String methodKey, Response response) {
    switch (response.status()) {
      case 404:
        return new UserNotFoundException("User not found");
      default:
        return defaultErrorDecoder.decode(methodKey, response);
    }
  }
}
