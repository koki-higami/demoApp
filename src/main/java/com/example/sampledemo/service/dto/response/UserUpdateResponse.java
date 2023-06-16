package com.example.sampledemo.service.dto.response;

import com.example.sampledemo.client.dto.response.UserFindBindResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserUpdateResponse {

  private Integer userId;
  private String firstName;
  private String lastName;
  private String email;

  public UserUpdateResponse(UserFindBindResponse res) {
    this.userId = res.getUserId();
    this.firstName = res.getFirstName();
    this.lastName = res.getLastName();
    this.email = res.getEmail();
  }
}
