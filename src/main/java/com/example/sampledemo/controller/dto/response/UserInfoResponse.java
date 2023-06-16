package com.example.sampledemo.controller.dto.response;

import com.example.sampledemo.service.dto.response.UserFindResponse;
import com.example.sampledemo.service.dto.response.UserUpdateResponse;
import lombok.Data;


//todo 名前がわかりにくい、他のDTOと混同する
@Data
public class UserInfoResponse {
  private Integer userId;
  private String firstName;
  private String lastName;
  private String email;

  public UserInfoResponse(UserFindResponse data) {
    this.userId = data.getUserId();
    this.firstName = data.getFirstName();
    this.lastName = data.getLastName();
    this.email = data.getEmail();
  }

  public UserInfoResponse(UserUpdateResponse data) {
    this.userId = data.getUserId();
    this.firstName = data.getFirstName();
    this.lastName = data.getLastName();
    this.email = data.getEmail();
  }
}
