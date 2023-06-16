package com.example.sampledemo.client.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserFindBindResponse {

  private Integer userId;
  private String firstName;
  private String lastName;
  private String email;

}
