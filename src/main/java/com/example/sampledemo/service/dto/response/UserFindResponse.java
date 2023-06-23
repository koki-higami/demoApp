package com.example.sampledemo.service.dto.response;

import com.example.sampledemo.client.dto.response.UserFindBindResponse;
import lombok.Data;

@Data
public class UserFindResponse {

  private Integer userId;
  private String firstName;
  private String lastName;
  private String email;

  public UserFindResponse(UserFindBindResponse res) {
    this.userId = res.getUserId();
    this.firstName = res.getFirstName();
    this.lastName = res.getLastName();
    this.email = res.getEmail();
  }
}
