package com.example.sampledemo.service.dto.request;

import com.example.sampledemo.controller.dto.request.UserInfoUpdateRequest;
import lombok.Getter;

@Getter
public class UserUpdateRequest {
  private String firstName;
  private String lastName;
  private String email;

  public UserUpdateRequest(UserInfoUpdateRequest req) {
    this.firstName = req.getFirstName();
    this.lastName = req.getLastName();
    this.email = req.getEmail();
  }
}
