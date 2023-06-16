package com.example.sampledemo.client.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserUpdateBindRequest {

  private String firstName;
  private String lastName;
  private String email;
}
